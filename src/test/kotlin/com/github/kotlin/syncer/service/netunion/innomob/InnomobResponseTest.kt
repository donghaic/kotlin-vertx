package com.github.kotlin.syncer.service.netunion.innomob

import com.alibaba.fastjson.JSON
import org.junit.jupiter.api.Test

internal class InnomobResponseTest {

  @Test
  fun json() {
    data class DataClassSimple(val a: Int, val b: Int, val cc: List<String>)

    val dts = DataClassSimple(1, 2, listOf("1", "2"))
    val jsons = JSON.toJSONString(dts)
    println(jsons)
    val clzs = DataClassSimple::class
    println(clzs.javaObjectType)
    val dt2 = JSON.parseObject(jsons, clzs.javaObjectType)
    println(dt2)
  }
}
