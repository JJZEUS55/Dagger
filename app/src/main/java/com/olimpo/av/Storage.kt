package com.olimpo.av

import javax.inject.Inject

class Storage {
    @Inject lateinit var uniqueMagic: UniqueMagic
    @Inject lateinit var normalMagic: NormalMagic
}