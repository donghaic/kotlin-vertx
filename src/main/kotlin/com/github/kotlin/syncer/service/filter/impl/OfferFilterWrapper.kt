package com.github.kotlin.syncer.service.filter.impl

import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.service.filter.IOfferFilter


class OfferFilterWrapper : IOfferFilter {
  override fun isSkip(offer: PushOffer.NetunionOffer): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}