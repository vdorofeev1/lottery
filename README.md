```
docker build -t lottery .
docker run -d -p 8080:8080 lottery
```

# Lottery Service - Java Developer Test Task

## Introduction
This project is a simple lottery service developed as a test task for the Java Developer position at Nexign. The goal of this service is to manage participants, conduct a lottery, and keep track of winners. The service is implemented in Java and uses Spring Boot as the framework.

## How to run
### Docker

```
docker pull vdrofoeev/lottery
docker run -d -p 8080:8080 vdorofeev/lottery
```
### Or

```
git clone https://github.com/vdorofeev1/lottery.git
cd lottery
/bin/bash scripts/run.sh
```
## Functionality

### Add Participant
Endpoint: POST /lottery/participant

Add a participant to the table of all participants
```
curl -X POST localhost:8080/lottery/participant -H 'Content-type:application/json' -d '{"name": "Andrey", "age": "23", "city": "Omsk"}'
```

### Get All Participants
Endpoint: GET /lottery/participant

Returns a list of all participants
```
curl -v localhost:8080/lottery/participant
```

### Start Lottery
Endpoint: GET /lottery/start

Chooses a winner with random amount of win(<1000).
If amount of participants is less than 2, exception will be thrown. Also adds a winner to the table of winners and cleans table of participants
```
curl -v localhost:8080/lottery/start
```


### View Winners
Endpoint: GET /lottery/winners

Returns a list of all winners
```
curl -v localhost:8080/lottery/winners
```