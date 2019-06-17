package com.github.kotlin.syncer.guice

import com.authzee.kotlinguice4.KotlinModule
import com.github.kotlin.syncer.service.filter.FilterModule
import com.github.kotlin.syncer.service.netunion.NetUnionModule
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

class MainModule(val vertx: Vertx) : KotlinModule() {
  override fun configure() {
    val config = vertx.orCreateContext.config()
    install { binder -> bind(Vertx::class.java).toInstance(vertx) }
    bind(JsonObject::class.java).toInstance(config)

    install(FilterModule())
    install(NetUnionModule())


  }
}