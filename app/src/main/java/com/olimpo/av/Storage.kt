package com.olimpo.av

import javax.inject.Inject

class Storage {
    @Inject @ScopeFragment lateinit var uniqueMagic: UniqueMagic
    @Inject lateinit var normalMagic: NormalMagic
}