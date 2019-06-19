package com.github.kotlin.syncer.service.filter.impl

import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.service.filter.IOfferFilter
import javax.inject.Inject


class OfferFilterWrapper @Inject constructor(var filters: Set<IOfferFilter>) : IOfferFilter {
  override suspend fun isSkip(offer: PushOffer.NetunionOffer): Boolean {
    for (filter in filters) {
      if (filter.isSkip(offer)) {
        return true
      }
    }
    return false
  }
}
