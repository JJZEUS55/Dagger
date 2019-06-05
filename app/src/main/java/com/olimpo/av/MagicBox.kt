package com.olimpo.av

import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@ScopeFragment
@Component(modules = [Bag::class])
interface MagicBox {
    fun poke(app: MainActivity)
    fun pokeStore(storage: Storage)
}

