package com.github.kotlin.syncer.service


object Const {
  //默认超时时间
  const val http_client_timeout = 20 * 1000


  const val offer_filter_rule_redis_key = "rule:id:%s"
  const val PULL_OFFER_RULE_COMMON_KEY = "offer:common"
  const val PULL_OFFER_RULE_PACKET_EKY = "packet"
}


