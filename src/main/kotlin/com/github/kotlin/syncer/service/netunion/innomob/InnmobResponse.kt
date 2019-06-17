package com.github.kotlin.syncer.service.netunion.innomob


data class InnomobResponse(
  val code: Int = 0,
  val message: String,
  val current: Int = 0,
  val page: Int = 0,
  val isNext_page: Boolean = false,
  val total_pages: Int = 0,
  val data: List<Item>
)

data class Item(
  val app_category: String?,
  val app_desc: String?,
  val app_min_ver: String?,
  val app_name: String?,
  val app_pack_name: String?,
  val black_subs: List<String>?,
  val cap_daily: Int = 0,

  val click_url: String?,
  val conv_flow: String?,
  val countries: List<String>?,
  val currency: String?,
  val d_type: String?,
  val desc: String?,
  val icons: List<String>?,
  val id: Int = 0,
  val images: List<Image>?,
  val incentive: String?,
  val name: String?,
  val need_deviceid: String?,
  val os: String?,
  val payout: Double = 0.toDouble(),
  val payout_type: String?,
  val preview_url: String?,
  val r_cap_daily: Int = 0
)

data class Image(
  val pixel: String,
  val url: String
)
