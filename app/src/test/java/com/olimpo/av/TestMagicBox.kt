package com.olimpo.av

import dagger.Component

@Component(modules = [Bag::class])
interface TestMagicBox : MagicBox {
    fun poke(app: TestMainActivity)
}