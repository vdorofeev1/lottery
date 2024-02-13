
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

![](https://private-user-images.githubusercontent.com/39113667/303970282-f18174ff-d498-4619-b3fb-1549672c0945.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDc4MzY2MjUsIm5iZiI6MTcwNzgzNjMyNSwicGF0aCI6Ii8zOTExMzY2Ny8zMDM5NzAyODItZjE4MTc0ZmYtZDQ5OC00NjE5LWIzZmItMTU0OTY3MmMwOTQ1LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAyMTMlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMjEzVDE0NTg0NVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWI0YmQ4NTBjMTg2NGUzM2ExNmExN2MxZWZjZDU4NWZiNDFmMjQ5ZGQwMjYzYzE4YzNiMjMyMmM2MjcyY2E3YWQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.G_sFm89FbtPPOW2NXvRbHTYjk2HWQwM0R3p5NO8YJqA)