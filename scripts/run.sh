#!/bin/bash

set -e

currentDir=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
rootDir="$currentDir/../"

cd "$rootDir"

VERSION=$(grep -oP '"VERSION": "\K[^"]+' scripts/upkg.json)
NAME=$(grep -oP '"NAME": "\K[^"]+' scripts/upkg.json)

/bin/bash scripts/build.sh

echo "BUILDED!"

echo $VERSION
echo $NAME

cp target/${NAME}-${VERSION}.jar docker/${NAME}-${VERSION}.jar

chmod a+x scripts/buildDockerImage.sh
/bin/bash scripts/buildDockerImage.sh

java -jar target/${NAME}-${VERSION}.jar
