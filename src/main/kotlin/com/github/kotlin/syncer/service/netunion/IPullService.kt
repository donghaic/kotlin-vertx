package com.github.kotlin.syncer.service.netunion

import com.github.kotlin.syncer.bean.OfferFilterRule
import com.github.kotlin.syncer.bean.NetunionOffer


interface IPullService {

  suspend fun pull(netUnionId: Int, rule: OfferFilterRule?): List<NetunionOffer>
}
