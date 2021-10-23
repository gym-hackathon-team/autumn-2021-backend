FROM python
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1
RUN pip install vosk gunicorn uvicorn numpy starlette python-multipart python-ffmpeg
COPY main.py ./
COPY model ./model
COPY model-spk ./model-spk
CMD gunicorn -w 4 -k uvicorn.workers.UvicornWorker -b 0.0.0.0:8000 main:app
