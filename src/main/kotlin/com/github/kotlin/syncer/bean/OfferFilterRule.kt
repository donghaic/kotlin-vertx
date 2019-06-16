package com.github.kotlin.syncer.bean


data class OfferFilterRule(
  //1 //最低价格 double
  val price_range_min: Double,
  //5 //最高价格 double
  val price_range_max: Double,
  //10 //最高跳转次数 int
  val redirection_count_max: Integer,
  //1 //探测结果 1;//成功,2;//不成功,0;//不限 int
  val detect_result: Integer,
  //321 //网盟id
  val netunion_id: Long,
  //1 //状态
  val status: Integer,

  val remarks: String,

  val netunion_name: String,
  //销售id
  val sales_id: Integer,
  //销售名称
  val sales_name: String,
  //运营id
  val operator_id: Integer,
  //运营名称
  val operator_name: String
)
