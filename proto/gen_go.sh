#!/usr/bin/env bash
set -e
rm -rf go
mkdir -p go/pb

protoc -I=/usr -I=proto/ --go_out=plugins=grpc:go/pb/. proto/*.proto
