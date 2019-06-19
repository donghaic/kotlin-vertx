package com.github.kotlin.syncer.service.filter.impl

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.service.Const
import com.github.kotlin.syncer.service.filter.IOfferFilter
import io.vertx.core.Vertx
import io.vertx.kotlin.redis.hgetAwait
import io.vertx.redis.RedisClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject


class PackageFilter @Inject constructor(val vertx: Vertx, val redisClient: RedisClient) : IOfferFilter {
  private val packetData = ConcurrentHashMap<String, Set<String>>()

  init {
    vertx.setPeriodic(10 * 60 * 1000) {
      GlobalScope.launch {
        loadPacketData()
      }
    }
  }


  override suspend fun isSkip(offer: PushOffer.NetunionOffer): Boolean {
    val packageName = offer.packageName
    return packetData.contains(packageName)
  }


  private suspend fun loadPacketData() {
    val json = redisClient.hgetAwait(Const.PULL_OFFER_RULE_COMMON_KEY, Const.PULL_OFFER_RULE_PACKET_EKY)
    val data = JSON.parseObject(json, object : TypeReference<Set<String>>() {
    })
    packetData[Const.PULL_OFFER_RULE_PACKET_EKY] = data
  }
}
