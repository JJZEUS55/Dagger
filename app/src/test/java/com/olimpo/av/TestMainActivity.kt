package com.olimpo.av

import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

class TestMainActivity {
    @Inject
    @field:Named("Love") lateinit var infoLove : Info
    @Inject
    @field:Named("Hello") lateinit var infoHello : Info

    @Before
    fun setup() {

    }

    @Test
    fun simpleTest(){

    }

}