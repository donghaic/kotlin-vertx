package com.github.kotlin.syncer.service.filter.impl

import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.service.filter.IOfferFilter
import com.google.common.base.Strings
import java.util.*

class FieldsCheckFilter : IOfferFilter {
  override suspend fun isSkip(offer: PushOffer.NetunionOffer): Boolean {
    // TODO click 地址？？
    if (Strings.isNullOrEmpty(offer.previewUrl)) {
      return true
    }
    if (Strings.isNullOrEmpty(offer.packageName)) {
      return true
    }
    if (offer.countriesCount == 0) {
      return true
    }
    if (offer.price <= 0) {
      return true
    }
    if (offer.dayCap <= 0) {
      return true
    }
    if (Objects.nonNull(offer.netunionName) && offer.netunionName.length > 50) {
      return true
    }
    return false
  }
}
