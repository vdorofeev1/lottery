#!/bin/bash
pwd

VERSION=$(grep -oP '"VERSION": "\K[^"]+' scripts/upkg.json)
NAME=$(grep -oP '"NAME": "\K[^"]+' scripts/upkg.json)
echo $VERSION
echo $NAME

mvn clean install -DskipTests -DVERSION="$VERSION" -DNAME="$NAME"