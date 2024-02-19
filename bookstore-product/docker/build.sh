#!/bin/bash
sh ../../gradlew --project-dir=.. :bookstore-product:clean :bookstore-product:bootJar
docker build -f Dockerfile -t bookstore-product:latest ../