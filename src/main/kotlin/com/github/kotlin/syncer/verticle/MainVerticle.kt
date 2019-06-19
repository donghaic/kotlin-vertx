package com.github.kotlin.syncer.verticle

import com.github.kotlin.syncer.guice.MainModule
import com.github.kotlin.syncer.service.ExchangeServcice
import com.google.inject.Guice
import io.vertx.ext.healthchecks.HealthCheckHandler
import io.vertx.ext.healthchecks.HealthChecks
import io.vertx.ext.healthchecks.Status
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.CorsHandler
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch
import mu.KotlinLogging
import javax.inject.Inject

class MainVerticle : CoroutineVerticle() {
  private val logger = KotlinLogging.logger { }

  private val interval_time = 1 * 60 * 1000L

  @Inject
  lateinit var exchangeServcice: ExchangeServcice

  override suspend fun start() {
    val injector = Guice.createInjector(MainModule(vertx))
    injector.injectMembers(this)

    vertx.setPeriodic(interval_time) {
      logger.info { "timer fired" }
      launch {
        exchangeServcice.exchange()
      }
    }
    launch {
      exchangeServcice.exchange()
    }

    val router = Router.router(vertx)
    val healthCheckHandler = HealthCheckHandler.createWithHealthChecks(HealthChecks.create(vertx))
    healthCheckHandler.register("Health") { future ->
      future.complete(Status.OK())
    }
    router.get("/ping*").handler(healthCheckHandler)
    router.apply {
      route().handler(BodyHandler.create(false))
      route().handler(CorsHandler.create("*"))
    }

    // Start the server
    val listenAwait = vertx.createHttpServer()
      .requestHandler(router)
      .listenAwait(config.getInteger("http.port", 8080))
    logger.info { "start on port  ${listenAwait.actualPort()}" }
  }
}
