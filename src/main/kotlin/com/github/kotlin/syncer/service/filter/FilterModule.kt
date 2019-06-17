package com.github.kotlin.syncer.service.filter

import com.authzee.kotlinguice4.KotlinModule
import com.authzee.kotlinguice4.multibindings.KotlinMultibinder
import com.github.kotlin.syncer.service.filter.impl.FieldsCheckFilter
import com.github.kotlin.syncer.service.filter.impl.OfferFilterWrapper
import com.github.kotlin.syncer.service.filter.impl.PackageFilter
import com.github.kotlin.syncer.service.filter.impl.PriceFilter

class FilterModule : KotlinModule() {
  override fun configure() {

    val filterBinder = KotlinMultibinder.newSetBinder<IOfferFilter>(kotlinBinder)
    filterBinder.addBinding().to<FieldsCheckFilter>()
    filterBinder.addBinding().to<PackageFilter>()
    filterBinder.addBinding().to<PriceFilter>()
    
    bind<IOfferFilter>().to<OfferFilterWrapper>()
  }
}
