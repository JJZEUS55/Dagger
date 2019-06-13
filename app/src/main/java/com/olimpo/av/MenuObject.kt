package com.olimpo.av

import android.view.View
import androidx.databinding.ObservableField

data class MenuObject(
    var title: String = "",
    var visibility: ObservableField<Boolean> = ObservableField<Boolean>(false)// Visibility GONE
)