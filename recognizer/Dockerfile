FROM python
VOLUME /data
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1
RUN apt update && apt install -y ffmpeg
COPY requirements.txt ./
RUN pip install -r requirements.txt
COPY model ./model
COPY model-spk ./model-spk
COPY clusterize.py ./
COPY main.py ./
CMD gunicorn -k uvicorn.workers.UvicornWorker -b 0.0.0.0:8080 main:app
