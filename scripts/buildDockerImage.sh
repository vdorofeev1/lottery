#!/bin/bash

VERSION=$(grep -oP '"VERSION": "\K[^"]+' scripts/upkg.json)
NAME=$(grep -oP '"NAME": "\K[^"]+' scripts/upkg.json)

cd docker
docker build --build-arg VERSION=${VERSION} --build-arg NAME=${NAME} -t vdorofeev/lottery .
