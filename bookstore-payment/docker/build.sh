#!/bin/bash
sh ../../gradlew --project-dir=.. :bookstore-payment:clean :bookstore-payment:bootJar
docker build -f Dockerfile -t bookstore-payment:latest ../