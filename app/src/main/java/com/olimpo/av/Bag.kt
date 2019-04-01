package com.olimpo.av

import dagger.Module
import dagger.Provides
import java.lang.annotation.RetentionPolicy
import javax.inject.Named
import javax.inject.Scope


@Module
open class Bag  {
    @Provides
    @Choose("Love")
    open fun sayLove(): Info{
        return Info("Love Dagger")
    }

    @Provides
    @Choose("Hello")
    open fun sayHello(): Info{
        return Info("SAYING HELLO")
    }
}