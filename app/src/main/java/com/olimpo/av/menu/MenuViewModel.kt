package com.olimpo.av.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel: ViewModel(){
    var lstLiveMenu:LiveData<List<MenuObject>> = MutableLiveData<List<MenuObject>>().apply {
        val lst = ArrayList<MenuObject>()
        val menu = MenuObject()
        menu.title = "Estatus"

        val menu2 = MenuObject()
        menu2.title = "Entregas"

        val menu3 = MenuObject()
        menu3.title = "Soporte"


        val menu4 = MenuObject()
        menu4.title = "Terminos y Condiciones"


        val menu5 = MenuObject()
        menu5.title = "Salir"

        lst.add(menu)
        lst.add(menu2)
        lst.add(menu3)
        lst.add(menu4)
        lst.add(menu5)
        value = lst
    }
}