package com.github.grpc.push_offer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;


public class GrpcServer extends AbstractVerticle {

    public static void main(String[] args) {
        System.out.println("--- Deploy MainVerticle ---");
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(GrpcServer.class.getName(), event -> {
                if (event.succeeded()) {
                    System.out.println("Your Vert.x application is started!");
                } else {
                    System.out.println("Unable to start your application");
                }
            }
        );
    }

    @Override
    public void start() {

        NetunionOfferPusherGrpc.NetunionOfferPusherVertxImplBase pusherVertxImplBase = new NetunionOfferPusherGrpc.NetunionOfferPusherVertxImplBase() {
            @Override
            public void pushNetunionOffer(PushOffer.PushNetunionOfferRequest request, Future<PushOffer.PushNetunionOfferResponse> response) {
                System.out.println("Hello " + request.getNetunionId());

                PushOffer.PushNetunionOfferResponse offerResponse = PushOffer.PushNetunionOfferResponse
                    .newBuilder()
                    .setCode(0)
                    .build();
                response.complete(offerResponse);
            }
        };


        VertxServer server = VertxServerBuilder
            .forAddress(vertx, "localhost", 8888)
            .addService(pusherVertxImplBase).build();
        server.start(ar -> {
            if (ar.succeeded()) {
                System.out.println("gRPC service started");
            } else {
                System.out.println("Could not start server " + ar.cause().getMessage());
            }
        });
    }
}
