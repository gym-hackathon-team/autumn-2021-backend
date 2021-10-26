import vosk
import pathlib
import json
import shutil
import subprocess
import re
import socket
import consul

import numpy as np

from starlette.applications import Starlette
from starlette.responses import JSONResponse, PlainTextResponse
from starlette.routing import Route

import clusterize

vosk.SetLogLevel(-2)
sample_rate = 16000
model = vosk.Model('model')
spk_model = vosk.SpkModel('model-spk')
dictionary = 'перевод пользователю оплатить услугу'
speaker_model = vosk.KaldiRecognizer(model, sample_rate, '["{}", "[unk]"]'.format(dictionary))
speaker_model.SetSpkModel(spk_model)
clusters = clusterize.Clusters(pathlib.Path('/data'))


def process_model_result(result_str):
    result = json.loads(result_str)
    try:
        text = result['text']
        if len(text) == 0:
            return None, None

        try:
            processed_frames = result['spk_frames']
        except KeyError:
            processed_frames = 0

        try:
            speaker = np.array(result['spk']) * processed_frames
        except KeyError:
            return None, None

        return text, speaker
    except KeyError:
        return None, None


def update_values(text, speaker, result_string):
    new_text, new_speaker = process_model_result(result_string)
    if new_text is None or new_speaker is None:
        return text, speaker
    else:
        text = text + ' ' + new_text

        if speaker is None:
            speaker = new_speaker
        else:
            speaker += new_speaker
        return text, speaker


async def recognize(request):
    try:
        form = await request.form()
        filename = form['upload_file'].filename
        with open(filename, 'wb') as f:
            shutil.copyfileobj(form['upload_file'].file, f)

        text = ''
        speaker = None

        process = subprocess.Popen(
            ['ffmpeg', '-loglevel', 'quiet', '-i', filename, '-ar', str(sample_rate), '-ac', '1', '-f', 's16le', '-'],
            stdout=subprocess.PIPE)
        data = ' '

        while len(data) > 0:
            data = process.stdout.read(4000)
            if speaker_model.AcceptWaveform(data):
                text, speaker = update_values(text, speaker, speaker_model.Result())

        text, speaker = update_values(text, speaker, speaker_model.FinalResult())

        if len(text) == 0 or speaker is None:
            print('Unable to recognize speech, reason unknown')
            return PlainTextResponse(status_code=500)
        else:
            voice_id = clusters.add_vector_and_get_id(speaker)
            text = re.sub(' +', ' ', text)
            text = re.sub('\\[unk]', '', text)
            text = text.strip()
            print('Recognized text: "{}"'.format(text))
            return JSONResponse({'words': text, 'voiceId': str(voice_id)}, status_code=200)
    except BaseException as err:
        print('Unexpected exception occurred: {}'.format(str(err)))
        return PlainTextResponse(status_code=500)


async def health_check(request):
    return PlainTextResponse('Still alive', status_code=200)


app = Starlette(routes=[
    Route('/recognize', recognize, methods=["POST"]),
    Route('/my-health-check', health_check, methods=["GET"])
])

ip_addr = socket.gethostbyname(socket.gethostname())
consul_client = consul.Consul('consul')
consul_client.agent.service.register(name='recognizer-service', port=8080, address=ip_addr,
                                     check=consul.Check.http(url='http://{}:8080/my-health-check'.format(ip_addr),
                                                             interval='5s'))
