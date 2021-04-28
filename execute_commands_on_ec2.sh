#!/usr/bin/env bash


kill -9 $(/usr/sbin/lsof -t -i:8080)
echo "Killed process running on port 8080"

java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 websockettrial-0.0.1-SNAPSHOT.jar
echo "Started server using java -jar command"