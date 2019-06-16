package com.github.kotlin.syncer.verticle

import io.vertx.core.Handler
import io.vertx.ext.healthchecks.HealthCheckHandler
import io.vertx.ext.healthchecks.HealthChecks
import io.vertx.ext.healthchecks.Status
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.CorsHandler
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.launch
import mu.KotlinLogging

class MainVerticle : CoroutineVerticle() {
  private val logger = KotlinLogging.logger { }

  val interval_time = 1 * 60 * 1000L

  override suspend fun start() {

    vertx.setPeriodic(interval_time) { logger.info { "timer fired" } }

    val router = Router.router(vertx)
    val healthCheckHandler = HealthCheckHandler.createWithHealthChecks(HealthChecks.create(vertx))
    healthCheckHandler.register("Health") { future ->
      future.complete(Status.OK())
    }
    router.apply {
      route().handler(BodyHandler.create(false))
      route().handler(CorsHandler.create("*"))
      router.get("/ping*").handler(healthCheckHandler)
    }


    // Start the server
    vertx.createHttpServer()
      .requestHandler(router)
      .listenAwait(config.getInteger("http.port", 8080))
    logger.info { "start on port 8080" }
  }


  /**
   * An extension method for simplifying coroutines usage with Vert.x Web routers
   */
  fun Route.coroutineHandler(fn: suspend (RoutingContext) -> Unit) {
    handler { ctx ->
      launch(ctx.vertx().dispatcher()) {
        try {
          fn(ctx)
        } catch (e: Exception) {
          ctx.fail(e)
        }
      }
    }
  }

}
