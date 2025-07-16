# Docker

## 개발용
```bash
docker build -f dockerfile.dev -t bict/pomit-api-dev .
docker tag bict/pomit-api-dev 192.168.0.18:5000/bict/pomit-api-dev
docker push 192.168.0.18:5000/bict/pomit-api-dev
docker run -d --gpus all -v %cd%:/app --name pomit-api-dev bict/pomit-api-dev tail -f /dev/null
```

## 프로덕션용
```bash
docker build -f dockerfile.prod -t bict/pomit-api .
docker tag bict/pomit-api 192.168.0.185:32000/bict/pomit-api
docker push 192.168.0.185:32000/bict/pomit-api
docker run --rm --gpus all bict/pomit-api
```

# 환경변수
- SERVER_PORT
- CONTEXT_PATH
- DB_URL
- DB_USERNAME
- DB_PASSWORD
- KAFKA_BOOTSTRAP_SERVERAdditional commit for project setup and PR automation.
