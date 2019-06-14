package com.olimpo.av.menu

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

class MenuObject : BaseObservable() {
    var id: Int = 0
    var title: String = ""

    var visibility: Boolean = false
        @Bindable
        get() = field
        @Bindable
        set(value) {
            field = value
            notifyChange()
        }
}