package com.github.kotlin.syncer.guice

import com.authzee.kotlinguice4.KotlinModule
import com.github.kotlin.syncer.service.filter.FilterModule
import com.github.kotlin.syncer.service.netunion.NetUnionModule
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

class MainModule(val vertx: Vertx) : KotlinModule() {
  override fun configure() {
    val config = vertx.orCreateContext.config()
    bind(JsonObject::class.java).toInstance(config)
    bind(Vertx::class.java).toInstance(vertx)
    install(FilterModule())
    install(NetUnionModule())
    install(RedisModule(vertx, config))
  }
}
