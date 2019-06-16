package com.github.kotlin.syncer.service.netunion.innomob


data class InnomobResponse(
  var code: Int = 0,
  var message: String,
  var current: Int = 0,
  var page: Int = 0,
  var isNext_page: Boolean = false,
  var total_pages: Int = 0,
  var data: List<Item>
)

data class Item(
  var app_category: String,
  var app_desc: String,
  var app_min_ver: String,
  var app_name: String,
  var app_pack_name: String,
  var black_subs: List<String>,
  var cap_daily: Int = 0,
  var click_url: String,
  var conv_flow: String,
  var countries: List<String>,
  var currency: String,
  var d_type: String,
  var desc: String,
  var icons: List<String>,
  var id: Int = 0,
  var images: List<Image>,
  var incentive: String,
  var name: String,
  var need_deviceid: String,
  var os: String,
  var payout: Double = 0.toDouble(),
  var payout_type: String,
  var preview_url: String,
  var r_cap_daily: Int = 0
)


data class Image(
  var pixel: String,
  var url: String
)
