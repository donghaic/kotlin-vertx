package com.github.kotlin.syncer.service.filter

import com.github.grpc.push_offer.PushOffer

interface IOfferFilter {

  suspend fun isSkip(offer: PushOffer.NetunionOffer): Boolean
}
