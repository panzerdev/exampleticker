FROM golang:1.9.1

WORKDIR /go/src/github.com/panzerdev/exampleticker/server

COPY . /go/src/github.com/panzerdev/exampleticker/server

RUN go get -v ./...
RUN go build -v -o /app/server

ENV PORT=3000

WORKDIR /app

ENTRYPOINT ["./server"]