package sample.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: url_ticker.proto")
public final class UrlTickerGrpc {

  private UrlTickerGrpc() {}

  public static final String SERVICE_NAME = "UrlTicker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sample.grpc.UrlRequest,
      sample.grpc.LinkTitlesResponse> getStreamTitlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamTitles",
      requestType = sample.grpc.UrlRequest.class,
      responseType = sample.grpc.LinkTitlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<sample.grpc.UrlRequest,
      sample.grpc.LinkTitlesResponse> getStreamTitlesMethod() {
    io.grpc.MethodDescriptor<sample.grpc.UrlRequest, sample.grpc.LinkTitlesResponse> getStreamTitlesMethod;
    if ((getStreamTitlesMethod = UrlTickerGrpc.getStreamTitlesMethod) == null) {
      synchronized (UrlTickerGrpc.class) {
        if ((getStreamTitlesMethod = UrlTickerGrpc.getStreamTitlesMethod) == null) {
          UrlTickerGrpc.getStreamTitlesMethod = getStreamTitlesMethod = 
              io.grpc.MethodDescriptor.<sample.grpc.UrlRequest, sample.grpc.LinkTitlesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "UrlTicker", "StreamTitles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.grpc.UrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.grpc.LinkTitlesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UrlTickerMethodDescriptorSupplier("StreamTitles"))
                  .build();
          }
        }
     }
     return getStreamTitlesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UrlTickerStub newStub(io.grpc.Channel channel) {
    return new UrlTickerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UrlTickerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UrlTickerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UrlTickerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UrlTickerFutureStub(channel);
  }

  /**
   */
  public static abstract class UrlTickerImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<sample.grpc.UrlRequest> streamTitles(
        io.grpc.stub.StreamObserver<sample.grpc.LinkTitlesResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamTitlesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamTitlesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                sample.grpc.UrlRequest,
                sample.grpc.LinkTitlesResponse>(
                  this, METHODID_STREAM_TITLES)))
          .build();
    }
  }

  /**
   */
  public static final class UrlTickerStub extends io.grpc.stub.AbstractStub<UrlTickerStub> {
    private UrlTickerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UrlTickerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UrlTickerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UrlTickerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<sample.grpc.UrlRequest> streamTitles(
        io.grpc.stub.StreamObserver<sample.grpc.LinkTitlesResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamTitlesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class UrlTickerBlockingStub extends io.grpc.stub.AbstractStub<UrlTickerBlockingStub> {
    private UrlTickerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UrlTickerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UrlTickerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UrlTickerBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class UrlTickerFutureStub extends io.grpc.stub.AbstractStub<UrlTickerFutureStub> {
    private UrlTickerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UrlTickerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UrlTickerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UrlTickerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_TITLES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UrlTickerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UrlTickerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_TITLES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamTitles(
              (io.grpc.stub.StreamObserver<sample.grpc.LinkTitlesResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UrlTickerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UrlTickerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sample.grpc.UrlOuterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UrlTicker");
    }
  }

  private static final class UrlTickerFileDescriptorSupplier
      extends UrlTickerBaseDescriptorSupplier {
    UrlTickerFileDescriptorSupplier() {}
  }

  private static final class UrlTickerMethodDescriptorSupplier
      extends UrlTickerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UrlTickerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UrlTickerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UrlTickerFileDescriptorSupplier())
              .addMethod(getStreamTitlesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
