package com.olimpo.av

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_generic.*

class DialogGeneric : DialogFragment() {

    var txtBody: String = "SIN TEXTO"
    var isCancelButton: Boolean = true
    var isOkButton: Boolean = true
    var visibilityButtonOk: Int = View.VISIBLE
    var visibilityButtonCancel: Int = View.VISIBLE

    var txtOkButton: String? = context?.getString(R.string.accept)
    var txtCancelButton: String? = context?.getString(R.string.cancel)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return inflater.inflate(R.layout.fragment_dialog_generic, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        txt_body.text = txtBody
        btn_ok.text = txtOkButton
        btn_cancel.text = txtCancelButton

        btn_ok.visibility = visibilityButtonOk
        btn_cancel.visibility = visibilityButtonCancel
    }

    fun changeTextBody(textBody: String){
        this.txtBody = textBody
    }

    fun quitCancelButton(){
        this.isCancelButton = false
    }

    fun quitOkButton(){
        this.isOkButton = false
    }

    fun changeTextButtonOk(text: String){
        this.txtOkButton = text
    }

    fun changeTextButtonCancel(text: String){
        this.txtCancelButton = text
    }

}