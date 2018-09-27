#!/usr/bin/env bash
set -e

rm -rf java
mkdir java

protoc -I=/usr -I=proto/ --java_out=java/. --grpc-java_out=java/ --plugin=protoc-gen-grpc-java=/usr/bin/protoc-gen-grpc-java proto/*.proto
