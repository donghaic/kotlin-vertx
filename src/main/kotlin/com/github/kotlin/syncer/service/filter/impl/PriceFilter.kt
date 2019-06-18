package com.github.kotlin.syncer.service.filter.impl

import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.service.filter.IOfferFilter

class PriceFilter : IOfferFilter {

  override fun isSkip(offer: PushOffer.NetunionOffer): Boolean {
    return false
  }
}
