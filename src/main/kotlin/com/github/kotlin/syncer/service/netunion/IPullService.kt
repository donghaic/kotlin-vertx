package com.github.kotlin.syncer.service.netunion

import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.bean.OfferFilterRule


interface IPullService {

  suspend fun pull(netUnionId: Int, rule: OfferFilterRule): List<PushOffer.NetunionOffer>
}
