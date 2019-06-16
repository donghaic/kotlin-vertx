package com.github.kotlin.syncer

import com.github.kotlin.syncer.verticle.MainVerticle
import io.vertx.core.Vertx
import io.vertx.kotlin.core.deployVerticleAwait
import mu.KotlinLogging

private val logger = KotlinLogging.logger { }


suspend fun main() {
  val vertx = Vertx.vertx()

  try {
    vertx.deployVerticleAwait(MainVerticle())
  } catch (e: Exception) {
    logger.info("Could not start application, msg:${e.message}")
  }
  logger.info { "deploy verticle OK" }
}
