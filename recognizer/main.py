import json
import wave
import numpy as np
import vosk
import asyncio
from starlette.applications import Starlette
from starlette.responses import JSONResponse
from starlette.routing import Route

vosk.SetLogLevel(-2)
sample_rate = 16000
model = vosk.Model("model")
spk_model = vosk.SpkModel("model-spk")
rec = vosk.KaldiRecognizer(model, sample_rate, spk_model)


async def recognize(request):
    await asyncio.sleep(3)
    try:
        form = await request.form()
        wf = wave.open(form["upload_file"].file, "rb")
        data = ' '
        text = ''
        speaker = None
        total_frames = 0
        while len(data) > 0:
            data = wf.readframes(4000)
            if rec.AcceptWaveform(data):
                res = json.loads(rec.Result())
                try:
                    txt = res['text']
                    if len(txt) > 0:
                        frames = 0
                        try:
                            frames = res['spk_frames']
                        except KeyError:
                            pass
                        try:
                            spk = res['spk']
                            if speaker is None:
                                speaker = np.array(spk) * frames
                            else:
                                speaker += np.array(spk) * frames
                        except KeyError:
                            pass
                        total_frames += frames
                        text = (text + ' ' + txt).strip()
                except KeyError:
                    pass
        return JSONResponse({'recognized': True, 'text': text, 'speaker': (speaker / total_frames).tolist()},
                            status_code=200)
    except BaseException as err:
        return JSONResponse({'recognized': False, 'reason': str(err)}, status_code=500)


app = Starlette(routes=[
    Route('/recognize', recognize, methods=["POST"])
])
