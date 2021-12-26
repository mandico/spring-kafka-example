END=100

for i in $(seq 1 $END); 
do 
    date=$(date '+%Y-%m-%d')
    curl -X POST -H "Content-Type: application/json" \
    -d '{"message": "Kafka Message '"$date"'"}' \
    http://localhost:8080/message
done