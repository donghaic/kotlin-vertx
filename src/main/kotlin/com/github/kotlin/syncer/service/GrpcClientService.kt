package com.github.kotlin.syncer.service

import com.github.grpc.push_offer.NetunionOfferPusherGrpc
import com.github.grpc.push_offer.PushOffer
import io.grpc.ManagedChannel
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.grpc.VertxChannelBuilder
import mu.KotlinLogging
import javax.inject.Inject


class GrpcClientService {
  private val log = KotlinLogging.logger { }
  private val channel: ManagedChannel
  private val vertx: Vertx
  private val config: JsonObject

  @Inject
  constructor(vertx: Vertx, config: JsonObject) {
    this.vertx = vertx
    this.config = config
    val grpc = config.getJsonObject("grpc", JsonObject())
    val host = grpc.getString("host", "localhost")
    val port = grpc.getInteger("port", 8888)
    this.channel = VertxChannelBuilder
      .forAddress(vertx, host, port)
      .usePlaintext(true)
      .build()
  }


  fun send(offerList: List<PushOffer.NetunionOffer>, netunionId: Int) {
    if (offerList.isEmpty()) {
      return
    }
    val stub = NetunionOfferPusherGrpc.newVertxStub(channel)
    val request = PushOffer.PushNetunionOfferRequest.newBuilder()
      .setNetunionId(netunionId)
      .addAllOffers(offerList)
      .build()
    stub.pushNetunionOffer(request) { resp ->
      if (resp.succeeded()) {
        log.info("Succeeded push offer to OfferCenter size:{} result:{}", offerList.size, resp.result())
      } else {
        log.error("Failed push offer error to OfferCenter", resp.cause())
        // TODO
      }
    }
  }
}
