echo "____ADDING PARTICIPANTS____"
curl -X POST localhost:8080/lottery/participant -H 'Content-type:application/json' -d '{"name": "Ivan", "age": "20", "city": "Moscow"}'
curl -X POST localhost:8080/lottery/participant -H 'Content-type:application/json' -d '{"name": "Fedor", "age": "21", "city": "Ufa"}'
curl -X POST localhost:8080/lottery/participant -H 'Content-type:application/json' -d '{"name": "Alexey", "age": "22", "city": "Rostov"}'
curl -X POST localhost:8080/lottery/participant -H 'Content-type:application/json' -d '{"name": "Andrey", "age": "23", "city": "Omsk"}'

echo ""
echo "____LISTING PARTICIPANTS____"
curl -v localhost:8080/lottery/participant

echo ""
echo "____STARTING LOTTERY____"
curl -v localhost:8080/lottery/start

echo ""
echo "____LISTING WINNERS____"
curl -v localhost:8080/lottery/winners

echo ""
echo "____LISTING PARTICIPANTS(idk why its not empty)____"
curl -v localhost:8080/lottery/participant



