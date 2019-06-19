package com.github.kotlin.syncer.service.filter.impl

import com.alibaba.fastjson.JSON
import com.github.grpc.push_offer.PushOffer
import com.github.kotlin.syncer.bean.OfferFilterRule
import com.github.kotlin.syncer.service.Const
import com.github.kotlin.syncer.service.filter.IOfferFilter
import io.vertx.kotlin.redis.getAwait
import io.vertx.redis.RedisClient
import javax.inject.Inject


class PriceFilter @Inject constructor(val redisClient: RedisClient) : IOfferFilter {

  override suspend fun isSkip(offer: PushOffer.NetunionOffer): Boolean {
    val netunionId = offer.netunionId
    val json = redisClient.getAwait(String.format(Const.offer_filter_rule_redis_key, netunionId))

    val offerFilterRule = JSON.parseObject(json, OfferFilterRule::class.java)

    if (offerFilterRule == null) {
      return false
    }

    // 没有配置规则,不过渡
    val price = offer.price
    val max = offerFilterRule.price_range_max
    val min = offerFilterRule.price_range_min
    // 价格小于最小，大于最大，过滤
    return price < min || price > max
  }
}
