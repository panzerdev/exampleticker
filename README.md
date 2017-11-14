# exampleticker
Simple bi-directional streaming example for `gRPC` with `Go` server and `Android` client
The Android client is based off the Android example in [https://github.com/grpc/grpc-java/tree/master/examples/android/helloworld]

## Server

To build the server Docker image just do in the `server` folder

```
docker build -t ticker_server .
```

and run it with 

```
docker run -p 3000:3000 --rm --name=ticker_server ticker_server
```

and stop it with 

```
docker stop ticker_server
```

The listening `port` is set to `3000` as the `ENV` `PORT` and can be changed when starting the container
```
docker run -e PORT=8080 -p 8080:8080 --rm --name=ticker_server ticker_server
```

## Client

To start the client the server `host` and `port` need to be set in the `TickerActivity`

For example:
```
private static final String mHostIp = "192.168.2.104";
private static final int mPort = 3000;
```

## Client usage

When the Button is pressed a bi-directional streaming connection will be opened and the first `RSS URL` sent to the Server.
The Server will now pull the feed, parse it and send `Title` and `Description` of the feed one by one to the client.
When the Button is hit again the next `RSS URL` will be sent and it starts from the beginning. 

When there are none left to send the stream will be terminated from the client side. 