import vosk
import json
import shutil
import subprocess
import re
import numpy as np
from starlette.applications import Starlette
from starlette.responses import JSONResponse
from starlette.routing import Route

vosk.SetLogLevel(-2)
sample_rate = 16000
model = vosk.Model('model')
spk_model = vosk.SpkModel('model-spk')
rec = vosk.KaldiRecognizer(model, sample_rate, spk_model)


def process_model_result(result_str):
    result = json.loads(result_str)
    try:
        text = result['text']
        if len(text) == 0:
            return None, None, None

        try:
            processed_frames = result['spk_frames']
        except KeyError:
            processed_frames = 0

        try:
            speaker = np.array(result['spk']) * processed_frames
        except KeyError:
            return None, None, None

        return text, processed_frames, speaker
    except KeyError:
        return None, None, None


def update_values(text, frames, speaker, result_string):
    new_text, new_frames, new_speaker = process_model_result(result_string)
    if new_text is None or new_frames is None or new_speaker is None:
        return text, frames, speaker
    else:
        text = text + ' ' + new_text
        frames += new_frames

        if speaker is None:
            speaker = new_speaker
        else:
            speaker += new_speaker
        return text, frames, speaker


async def recognize(request):
    try:
        form = await request.form()
        filename = form['upload_file'].filename
        with open(filename, 'wb') as f:
            shutil.copyfileobj(form['upload_file'].file, f)

        text = ''
        frames = 0
        speaker = None

        process = subprocess.Popen(
            ['ffmpeg', '-loglevel', 'quiet', '-i', filename, '-ar', str(sample_rate), '-ac', '1', '-f', 's16le', '-'],
            stdout=subprocess.PIPE)
        data = ' '

        while len(data) > 0:
            data = process.stdout.read(4000)
            if rec.AcceptWaveform(data):
                text, frames, speaker = update_values(text, frames, speaker, rec.Result())

        text, frames, speaker = update_values(text, frames, speaker, rec.FinalResult())

        if len(text) == 0 or frames == 0 or speaker is None:
            print('Unable to recognize speech, reason unknown')
            return JSONResponse({}, status_code=500)
        else:
            return JSONResponse({'success': True, 'text': re.sub('\\[unk]', '', re.sub(' +', ' ', text)),
                                 'speaker': (speaker / frames).tolist()}, status_code=200)
    except BaseException as err:
        print('Unexpected exception occurred: {}'.format(str(err)))
        return JSONResponse({}, status_code=500)


app = Starlette(routes=[
    Route('/recognize', recognize, methods=["POST"])
])
