package com.olimpo.av.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.olimpo.av.MenuObject

class MenuViewModel: ViewModel(){
    var lstLiveMenu:LiveData<List<MenuObject>> = MutableLiveData<List<MenuObject>>().apply {
        val lst = ArrayList<MenuObject>()
        lst.add(MenuObject("Estatus", false))
        lst.add(MenuObject("Entregas", false))
//        lst.add(MenuObject("Soporte", ObservableField(false)))
//        lst.add(MenuObject("Terminos y Condiciones", ObservableField(false)))
//        lst.add(MenuObject("Salir", ObservableField(false)))
        value = lst
    }
}