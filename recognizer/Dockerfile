FROM python
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1
RUN apt update && apt install -y ffmpeg
RUN pip install vosk gunicorn uvicorn numpy starlette python-multipart
COPY main.py ./
COPY clusterize.py ./
COPY model ./model
COPY model-spk ./model-spk
VOLUME /data
CMD gunicorn -k uvicorn.workers.UvicornWorker -b 0.0.0.0:8080 main:app
