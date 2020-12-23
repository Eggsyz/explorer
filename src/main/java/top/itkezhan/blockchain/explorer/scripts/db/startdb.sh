#/bin/bash
if [[ "$(docker ps -a |grep my_explorerdb> /dev/null)" == "" ]]; then
  docker rm -f my_explorerdb
fi
if [[ "$(docker images -q explorerdb 2> /dev/null)" == "" ]]; then
  docker build -t explorerdb .
fi
docker run --name my_explorerdb -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d explorerdb
