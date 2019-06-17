package com.github.kotlin.syncer.service

import com.github.kotlin.syncer.service.netunion.innomob.TestModule
import com.google.inject.Guice
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import javax.inject.Inject

internal class ExchangeServciceTest {

  @Inject
  lateinit var exchangeServcice: ExchangeServcice

  @Test
  fun exchange() {

    val injector = Guice.createInjector(TestModule())
    injector.injectMembers(this)
    runBlocking {
      exchangeServcice.exchange()
    }
    println("OK")
  }
}
