#!/bin/bash

VERSION=$(grep -oP '"VERSION": "\K[^"]+' scripts/upkg.json)
NAME=$(grep -oP '"NAME": "\K[^"]+' scripts/upkg.json)

mvn clean install -DVERSION="$VERSION" -DNAME="$NAME"

DOCKER_FOLDER="docker"
echo $VERSION
echo $NAME

cp target/${NAME}-${VERSION}.jar $DOCKER_FOLDER/app.jar
chmod a+x scripts/buildDocker.sh
/bin/bash scripts/buildDocker.sh

java -jar target/${NAME}-${VERSION}.jar
