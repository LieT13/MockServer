
# Mock server

## Run
```shell
docker-compose build
docker-compose up --scale mock=4
```

## Endpoints

* /mock
* /mockSleep5000
* /mockSleep10000
* /mockStatus/{httpStatus}
