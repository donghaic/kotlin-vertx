package com.github.kotlin.syncer.service.netunion.innomob

import com.github.kotlin.syncer.bean.NetunionOffer
import com.github.kotlin.syncer.bean.OfferFilterRule
import com.github.kotlin.syncer.service.Const
import com.github.kotlin.syncer.service.netunion.IPullService
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.ext.web.codec.BodyCodec
import io.vertx.kotlin.ext.web.client.sendAwait
import java.util.Collections.emptyList


const val URL = "http://api.innoentropy.com/v2/offer/pull?token=9b52230bcaa14a2d9599b075371a1ce4&page=%s&size=1000"
const val MACRO = "&click_id=__CLICKID__&aff_sub=__CHANNEL__-__SUBCHANNEL__&gaid=__GOOGLEADVID__&android_id=__ANDROIDID__"

class InnomobPullService(vertx: Vertx) : IPullService {
  private val webClient: WebClient

  init {
    val options = WebClientOptions().setConnectTimeout(Const.http_client_timeout)
    this.webClient = WebClient.create(vertx, options)
  }

  override suspend fun pull(netUnionId: Int, rule: OfferFilterRule?): List<NetunionOffer> {
    val url = String.format(URL, 1)
    println(url)
    val httpResponse = webClient.getAbs(url).timeout(Const.http_client_timeout.toLong()).`as`(BodyCodec.string()).sendAwait()


    // TODO
    println(httpResponse.body())
    return emptyList()
  }


  private fun mapToGrpc(response: InnomobResponse, rule: OfferFilterRule): List<NetunionOffer> {
    return emptyList()
  }


}
