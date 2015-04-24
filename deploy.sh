#!/bin/bash
echo hej
docker run -d -v /home/core/$(ls -1rt | grep .*jar$ | tail -n 1):/data/app.jar dockerfile/java:oracle-java8 java -jar /data/app.jar
