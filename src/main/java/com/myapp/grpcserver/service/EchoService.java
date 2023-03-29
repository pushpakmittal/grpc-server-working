package com.myapp.grpcserver.service;

import com.myapp.grpc_server.proto.EchoMessage;
import com.myapp.grpc_server.proto.EchoServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class EchoService extends EchoServiceGrpc.EchoServiceImplBase {

    @Override
    public void echo(EchoMessage request, StreamObserver<EchoMessage> responseObserver) {
        responseObserver.onNext(EchoMessage.newBuilder().setValue("welcome").build());
        responseObserver.onCompleted();
    }
}
