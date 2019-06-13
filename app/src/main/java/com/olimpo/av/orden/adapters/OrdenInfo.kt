package com.olimpo.av.orden.adapters

class OrdenInfo(

) {
    lateinit var data: Array<String>

    constructor(
        idRegister: String,
        nameAgent: String,
        valueMoney: String,
        remit: String
    ) : this() {
        data = arrayOf(idRegister, nameAgent, valueMoney, remit)
    }
}