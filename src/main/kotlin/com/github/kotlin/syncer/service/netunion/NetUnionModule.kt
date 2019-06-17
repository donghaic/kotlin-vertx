package com.github.kotlin.syncer.service.netunion

import com.authzee.kotlinguice4.KotlinModule
import com.authzee.kotlinguice4.multibindings.KotlinMapBinder
import com.github.kotlin.syncer.service.netunion.innomob.InnomobPullService

class NetUnionModule : KotlinModule() {
  override fun configure() {

    val mapbinder = KotlinMapBinder.newMapBinder<Int, IPullService>(kotlinBinder)

    mapbinder.addBinding(NetUnion.Filexmedia.id).to<InnomobPullService>()
  }
}
