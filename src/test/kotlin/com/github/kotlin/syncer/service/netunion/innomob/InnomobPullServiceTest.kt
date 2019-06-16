package com.github.kotlin.syncer.service.netunion.innomob

import io.vertx.core.Vertx
import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class InnomobPullServiceTest {

  @Test
  fun pull() {

    runBlocking {
      val innomobPullService = InnomobPullService(Vertx.vertx())
      val job = GlobalScope.launch {
        val list = innomobPullService.pull(1, null)
      }

      job.join()
    }

    println("End")

  }
}
