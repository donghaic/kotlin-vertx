package com.github.kotlin.syncer.service.netunion.innomob

import com.github.kotlin.syncer.bean.OfferFilterRule
import io.vertx.core.Vertx
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class InnomobPullServiceTest {

  @Test
  fun pull() {

    val rule = OfferFilterRule()

    runBlocking {
      val innomobPullService = InnomobPullService(Vertx.vertx())
      val job = GlobalScope.launch {
        val list = innomobPullService.pull(1, rule)
      }

      job.join()
    }

    println("End")

  }
}
