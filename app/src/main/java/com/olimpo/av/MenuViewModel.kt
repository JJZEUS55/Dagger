package com.olimpo.av

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel: ViewModel(){

    var lstLiveMenu:LiveData<List<MenuObject>> = MutableLiveData<List<MenuObject>>().apply {
        val lst = ArrayList<MenuObject>()
        lst.add(MenuObject("Estatus", ObservableField(false)))
        lst.add(MenuObject("Entregas", ObservableField(false)))
        lst.add(MenuObject("Soporte", ObservableField(false)))
        lst.add(MenuObject("Terminos y Condiciones", ObservableField(false)))
        lst.add(MenuObject("Salir", ObservableField(false)))
        value = lst
    }

}