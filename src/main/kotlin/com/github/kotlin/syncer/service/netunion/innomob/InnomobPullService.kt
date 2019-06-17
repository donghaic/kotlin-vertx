package com.github.kotlin.syncer.service.netunion.innomob

import com.alibaba.fastjson.JSON
import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.bean.OfferFilterRule
import com.github.kotlin.syncer.service.Const
import com.github.kotlin.syncer.service.netunion.IPullService
import com.github.kotlin.syncer.service.netunion.NetUnion
import com.google.common.collect.Lists
import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.ext.web.codec.BodyCodec
import io.vertx.kotlin.ext.web.client.sendAwait
import mu.KotlinLogging
import java.util.Collections.emptyList
import javax.inject.Inject


const val URL = "http://api.innoentropy.com/v2/offer/pull?token=9b52230bcaa14a2d9599b075371a1ce4&page=%s&size=10"
const val MACRO = "&click_id=__CLICKID__&aff_sub=__CHANNEL__-__SUBCHANNEL__&gaid=__GOOGLEADVID__&android_id=__ANDROIDID__"


class InnomobPullService : IPullService {

  @Inject
  constructor(vertx: Vertx) {
    val options = WebClientOptions().setConnectTimeout(Const.http_client_timeout)
    this.webClient = WebClient.create(vertx, options)
  }

  private val logger = KotlinLogging.logger { }
  private val webClient: WebClient

  override suspend fun pull(netUnionId: Int, rule: OfferFilterRule): List<PushOffer.NetunionOffer> {
    val url = String.format(URL, 1)
    logger.info("pull netUnionId=$netUnionId, url=$url")
    val httpResponse = webClient.getAbs(url).timeout(Const.http_client_timeout.toLong()).`as`(BodyCodec.string()).sendAwait()
    val innomobResponse = JSON.parseObject(httpResponse.body(), InnomobResponse::class.javaObjectType)
    val mapToGrpc = this.mapToGrpc(innomobResponse, rule)
    return mapToGrpc
  }


  private fun mapToGrpc(response: InnomobResponse, rule: OfferFilterRule): List<PushOffer.NetunionOffer> {
    return handleData(response.data, rule)
  }

  private fun handleData(itemList: List<Item>, rule: OfferFilterRule): List<PushOffer.NetunionOffer> {
    val innomob = NetUnion.Innomob
    if (itemList == null) {
      return emptyList()
    }
    val result = Lists.newArrayList<PushOffer.NetunionOffer>()
    for (item in itemList) {
      val pushOffer = PushOffer.NetunionOffer.newBuilder()
        .setCategory(item.app_category)
        .addAllCountries(item.countries.orEmpty())
        .setDayCap(item.cap_daily)
        .setKpi(item.desc)
        .build()
      result.add(pushOffer)
    }
    return result
  }

}
