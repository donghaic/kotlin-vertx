package com.github.kotlin.syncer.guice

import com.authzee.kotlinguice4.KotlinModule
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.kotlin.redis.pingAwait
import io.vertx.redis.RedisClient
import io.vertx.redis.RedisOptions
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging


class RedisModule(val vertx: Vertx, val conf: JsonObject) : KotlinModule() {

  private val log = KotlinLogging.logger { }


  override fun configure() {
    bind(RedisClient::class.java).toInstance(newRedisClient(conf))
  }

  private fun newRedisClient(conf: JsonObject): RedisClient {
    val redis = conf.getJsonObject("redis")
    val redisClient = buildRedisClient(redis)
    runBlocking {
      val pong = redisClient.pingAwait()
      log.info { "ping redis returns with $pong" }
    }
    return redisClient
  }

  private fun buildRedisClient(redis: JsonObject): RedisClient {
    val host = redis.getString("host", "localhost")
    val port = redis.getInteger("port").or(6379)
    val auth = redis.getString("auth").orEmpty()
    val db = redis.getInteger("db").or(0)
    val config = RedisOptions()
    config.host = host
    config.port = port
    config.select = db
    config.auth = auth
    config.connectTimeout = 100 * 1000

    val json = JsonObject.mapFrom(config)
    return RedisClient.create(vertx, json)
  }
}
