package com.github.grpc.push_offer;

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
 * <pre>
 *订单推送服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: Push_Offer.proto")
public final class NetunionOfferPusherGrpc {

  private NetunionOfferPusherGrpc() {}

  private static <T> io.grpc.stub.StreamObserver<T> toObserver(final io.vertx.core.Handler<io.vertx.core.AsyncResult<T>> handler) {
    return new io.grpc.stub.StreamObserver<T>() {
      private volatile boolean resolved = false;
      @Override
      public void onNext(T value) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture(value));
        }
      }

      @Override
      public void onError(Throwable t) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.failedFuture(t));
        }
      }

      @Override
      public void onCompleted() {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture());
        }
      }
    };
  }

  public static final String SERVICE_NAME = "com.github.grpc.push_offer.NetunionOfferPusher";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPushNetunionOfferMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest,
      com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> METHOD_PUSH_NETUNION_OFFER = getPushNetunionOfferMethod();

  private static volatile io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest,
      com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> getPushNetunionOfferMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest,
      com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> getPushNetunionOfferMethod() {
    io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest, com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> getPushNetunionOfferMethod;
    if ((getPushNetunionOfferMethod = NetunionOfferPusherGrpc.getPushNetunionOfferMethod) == null) {
      synchronized (NetunionOfferPusherGrpc.class) {
        if ((getPushNetunionOfferMethod = NetunionOfferPusherGrpc.getPushNetunionOfferMethod) == null) {
          NetunionOfferPusherGrpc.getPushNetunionOfferMethod = getPushNetunionOfferMethod = 
              io.grpc.MethodDescriptor.<com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest, com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.github.grpc.push_offer.NetunionOfferPusher", "PushNetunionOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NetunionOfferPusherMethodDescriptorSupplier("PushNetunionOffer"))
                  .build();
          }
        }
     }
     return getPushNetunionOfferMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPushDataMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.DataRequest,
      com.github.grpc.push_offer.PushOffer.DataResponse> METHOD_PUSH_DATA = getPushDataMethod();

  private static volatile io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.DataRequest,
      com.github.grpc.push_offer.PushOffer.DataResponse> getPushDataMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.DataRequest,
      com.github.grpc.push_offer.PushOffer.DataResponse> getPushDataMethod() {
    io.grpc.MethodDescriptor<com.github.grpc.push_offer.PushOffer.DataRequest, com.github.grpc.push_offer.PushOffer.DataResponse> getPushDataMethod;
    if ((getPushDataMethod = NetunionOfferPusherGrpc.getPushDataMethod) == null) {
      synchronized (NetunionOfferPusherGrpc.class) {
        if ((getPushDataMethod = NetunionOfferPusherGrpc.getPushDataMethod) == null) {
          NetunionOfferPusherGrpc.getPushDataMethod = getPushDataMethod = 
              io.grpc.MethodDescriptor.<com.github.grpc.push_offer.PushOffer.DataRequest, com.github.grpc.push_offer.PushOffer.DataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.github.grpc.push_offer.NetunionOfferPusher", "PushData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.grpc.push_offer.PushOffer.DataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.grpc.push_offer.PushOffer.DataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NetunionOfferPusherMethodDescriptorSupplier("PushData"))
                  .build();
          }
        }
     }
     return getPushDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NetunionOfferPusherStub newStub(io.grpc.Channel channel) {
    return new NetunionOfferPusherStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NetunionOfferPusherBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NetunionOfferPusherBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NetunionOfferPusherFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NetunionOfferPusherFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static NetunionOfferPusherVertxStub newVertxStub(io.grpc.Channel channel) {
    return new NetunionOfferPusherVertxStub(channel);
  }

  /**
   * <pre>
   *订单推送服务
   * </pre>
   */
  public static abstract class NetunionOfferPusherImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *推送订单
     * </pre>
     */
    public void pushNetunionOffer(com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest request,
        io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPushNetunionOfferMethod(), responseObserver);
    }

    /**
     * <pre>
     *推送数据
     * </pre>
     */
    public void pushData(com.github.grpc.push_offer.PushOffer.DataRequest request,
        io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.DataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPushDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPushNetunionOfferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest,
                com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>(
                  this, METHODID_PUSH_NETUNION_OFFER)))
          .addMethod(
            getPushDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.github.grpc.push_offer.PushOffer.DataRequest,
                com.github.grpc.push_offer.PushOffer.DataResponse>(
                  this, METHODID_PUSH_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   *订单推送服务
   * </pre>
   */
  public static final class NetunionOfferPusherStub extends io.grpc.stub.AbstractStub<NetunionOfferPusherStub> {
    public NetunionOfferPusherStub(io.grpc.Channel channel) {
      super(channel);
    }

    public NetunionOfferPusherStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetunionOfferPusherStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NetunionOfferPusherStub(channel, callOptions);
    }

    /**
     * <pre>
     *推送订单
     * </pre>
     */
    public void pushNetunionOffer(com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest request,
        io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPushNetunionOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *推送数据
     * </pre>
     */
    public void pushData(com.github.grpc.push_offer.PushOffer.DataRequest request,
        io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.DataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPushDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *订单推送服务
   * </pre>
   */
  public static final class NetunionOfferPusherBlockingStub extends io.grpc.stub.AbstractStub<NetunionOfferPusherBlockingStub> {
    public NetunionOfferPusherBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    public NetunionOfferPusherBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetunionOfferPusherBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NetunionOfferPusherBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *推送订单
     * </pre>
     */
    public com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse pushNetunionOffer(com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest request) {
      return blockingUnaryCall(
          getChannel(), getPushNetunionOfferMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *推送数据
     * </pre>
     */
    public com.github.grpc.push_offer.PushOffer.DataResponse pushData(com.github.grpc.push_offer.PushOffer.DataRequest request) {
      return blockingUnaryCall(
          getChannel(), getPushDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *订单推送服务
   * </pre>
   */
  public static final class NetunionOfferPusherFutureStub extends io.grpc.stub.AbstractStub<NetunionOfferPusherFutureStub> {
    public NetunionOfferPusherFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    public NetunionOfferPusherFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetunionOfferPusherFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NetunionOfferPusherFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *推送订单
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> pushNetunionOffer(
        com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPushNetunionOfferMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *推送数据
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.grpc.push_offer.PushOffer.DataResponse> pushData(
        com.github.grpc.push_offer.PushOffer.DataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPushDataMethod(), getCallOptions()), request);
    }
  }

  /**
   * <pre>
   *订单推送服务
   * </pre>
   */
  public static abstract class NetunionOfferPusherVertxImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *推送订单
     * </pre>
     */
    public void pushNetunionOffer(com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest request,
        io.vertx.core.Future<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse> response) {
      asyncUnimplementedUnaryCall(getPushNetunionOfferMethod(), NetunionOfferPusherGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     *推送数据
     * </pre>
     */
    public void pushData(com.github.grpc.push_offer.PushOffer.DataRequest request,
        io.vertx.core.Future<com.github.grpc.push_offer.PushOffer.DataResponse> response) {
      asyncUnimplementedUnaryCall(getPushDataMethod(), NetunionOfferPusherGrpc.toObserver(response.completer()));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPushNetunionOfferMethod(),
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest,
                com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>(
                  this, METHODID_PUSH_NETUNION_OFFER)))
          .addMethod(
            getPushDataMethod(),
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.github.grpc.push_offer.PushOffer.DataRequest,
                com.github.grpc.push_offer.PushOffer.DataResponse>(
                  this, METHODID_PUSH_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   *订单推送服务
   * </pre>
   */
  public static final class NetunionOfferPusherVertxStub extends io.grpc.stub.AbstractStub<NetunionOfferPusherVertxStub> {
    public NetunionOfferPusherVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    public NetunionOfferPusherVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetunionOfferPusherVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NetunionOfferPusherVertxStub(channel, callOptions);
    }

    /**
     * <pre>
     *推送订单
     * </pre>
     */
    public void pushNetunionOffer(com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(getPushNetunionOfferMethod(), getCallOptions()), request, NetunionOfferPusherGrpc.toObserver(response));
    }

    /**
     * <pre>
     *推送数据
     * </pre>
     */
    public void pushData(com.github.grpc.push_offer.PushOffer.DataRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.github.grpc.push_offer.PushOffer.DataResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(getPushDataMethod(), getCallOptions()), request, NetunionOfferPusherGrpc.toObserver(response));
    }
  }

  private static final int METHODID_PUSH_NETUNION_OFFER = 0;
  private static final int METHODID_PUSH_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NetunionOfferPusherImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NetunionOfferPusherImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUSH_NETUNION_OFFER:
          serviceImpl.pushNetunionOffer((com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>) responseObserver);
          break;
        case METHODID_PUSH_DATA:
          serviceImpl.pushData((com.github.grpc.push_offer.PushOffer.DataRequest) request,
              (io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.DataResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class VertxMethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NetunionOfferPusherVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(NetunionOfferPusherVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUSH_NETUNION_OFFER:
          serviceImpl.pushNetunionOffer((com.github.grpc.push_offer.PushOffer.PushNetunionOfferRequest) request,
              (io.vertx.core.Future<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>) io.vertx.core.Future.<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.PushNetunionOfferResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_PUSH_DATA:
          serviceImpl.pushData((com.github.grpc.push_offer.PushOffer.DataRequest) request,
              (io.vertx.core.Future<com.github.grpc.push_offer.PushOffer.DataResponse>) io.vertx.core.Future.<com.github.grpc.push_offer.PushOffer.DataResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.github.grpc.push_offer.PushOffer.DataResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NetunionOfferPusherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NetunionOfferPusherBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.grpc.push_offer.PushOffer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NetunionOfferPusher");
    }
  }

  private static final class NetunionOfferPusherFileDescriptorSupplier
      extends NetunionOfferPusherBaseDescriptorSupplier {
    NetunionOfferPusherFileDescriptorSupplier() {}
  }

  private static final class NetunionOfferPusherMethodDescriptorSupplier
      extends NetunionOfferPusherBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NetunionOfferPusherMethodDescriptorSupplier(String methodName) {
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
      synchronized (NetunionOfferPusherGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NetunionOfferPusherFileDescriptorSupplier())
              .addMethod(getPushNetunionOfferMethod())
              .addMethod(getPushDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
