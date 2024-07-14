**save-->**

curl --location 'localhost:8080/save' \
--header 'Content-Type: application/json' \
--data '{
    "id" : 3,
    "data" : " 3 first data"
}'

**get ->**

curl --location --request GET 'localhost:8080/get' \
--header 'Content-Type: application/json' \
--data '{
    "id" : 4
}'


**delete ->**

curl --location 'localhost:8080/delete' \
--header 'Content-Type: application/json' \
--data '{
    "id" : 4
}'

