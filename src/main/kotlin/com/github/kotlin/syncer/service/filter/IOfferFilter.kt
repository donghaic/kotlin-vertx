package com.github.kotlin.syncer.service.filter

import com.github.kotlin.syncer.bean.NetunionOffer

interface IOfferFilter {
  
  fun isSkip(offer: NetunionOffer): Boolean
}
