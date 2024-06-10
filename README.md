# glasses_online （The gear of fate rotates）
demo 需要提前安装jdk17 docker
• docker pull mongo
运⾏ MongoDB 镜像
• docker run --name mongo -p 27017:27017 -v ~/docker- data/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin
-e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo
docker exec -it mongo bash
mongo -u admin -p admin

