#!/bin/bash

VERSION=$(grep -oP '"VERSION": "\K[^"]+' scripts/upkg.json)
NAME=$(grep -oP '"NAME": "\K[^"]+' scripts/upkg.json)

/bin/bash scripts/build.sh

echo $VERSION
echo $NAME

cp target/${NAME}-${VERSION}.jar $DOCKER_FOLDER/${NAME}-${VERSION}.jar
chmod a+x scripts/buildDockerImage.sh
/bin/bash scripts/buildDockerImage.sh

#java -jar target/${NAME}-${VERSION}.jar
