package com.github.kotlin.syncer.service

import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.bean.OfferFilterRule
import com.github.kotlin.syncer.service.filter.IOfferFilter
import com.github.kotlin.syncer.service.netunion.IPullService
import com.google.common.collect.Lists
import mu.KotlinLogging
import javax.inject.Inject


class ExchangeServcice @Inject constructor(
  private val pullerServiceMap: Map<Int, IPullService>,
  private val filter: IOfferFilter,
  private val grpcClientService: GrpcClientService
) {

  private val log = KotlinLogging.logger { }

  suspend fun exchange() {
    val rule = OfferFilterRule()
    for ((netUnionId, v) in pullerServiceMap) {
      val originList = v.pull(netUnionId, rule)
      val offerList = this.doFilter(originList)
      log.info("send rpc, netUnionId=" + netUnionId + ", before fiter size=${originList.size}, after filter offers size=${offerList.size}")
      grpcClientService.send(offerList, netUnionId)
    }
  }

  private fun doFilter(originList: List<PushOffer.NetunionOffer>): List<PushOffer.NetunionOffer> {
    val result = Lists.newArrayList<PushOffer.NetunionOffer>()
    for (netunionOffer in originList) {
      if (!filter.isSkip(netunionOffer)) {
        result.add(netunionOffer)
      }
    }
    return result
  }
}
