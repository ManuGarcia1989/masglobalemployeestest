FROM python:3

ENV PYTHONUNBUFFERED=1
ENV C_FORCE_ROOT=1

ENV DOCKYARD_SRC=.
ENV DOCKYARD_SRVHOME=/srv
ENV DOCKYARD_SRVPROJ=/srv/src

WORKDIR $DOCKYARD_SRVHOME
RUN apt update && apt install gdal-bin -y

COPY $DOCKYARD_SRC $DOCKYARD_SRVPROJ

# Port to expose
EXPOSE 8000

# Copy entrypoint script into the image
WORKDIR $DOCKYARD_SRVPROJ

RUN pip install -r $DOCKYARD_SRVPROJ/requirements.txt

#ADD docker-entrypoint.sh /docker-entrypoint.sh
#RUN chmod +x /docker-entrypoint.sh
#CMD ["sh", "/docker-entrypoint.sh"]