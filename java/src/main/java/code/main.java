package code;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import sample.grpc.UrlTickerGrpc;

public class main {

    public static void main(String args[]){
        String host= "";
        int port= 0;

        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress(host, port).usePlaintext();
        ManagedChannel channel = channelBuilder.build();
        UrlTickerGrpc.UrlTickerBlockingStub blockingStub = UrlTickerGrpc.newBlockingStub(channel);
        UrlTickerGrpc.UrlTickerStub asyncStub = UrlTickerGrpc.newStub(channel);

        
    }
}
