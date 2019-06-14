package com.olimpo.av.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.olimpo.av.R
import kotlinx.android.synthetic.main.fragment_dialog_generic.*

class DialogGeneric : DialogFragment() {

    var txtTitle: String = "NO TITLE"
    var txtBody: String = "NO TEXT"
    var visibilityButtonOk: Int = View.VISIBLE
    var visibilityButtonCancel: Int = View.VISIBLE
    var imageTitle: Int = R.drawable.ic_phone

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
        if(txtTitle != "NO TITLE"){
            lyt_title_dialog.visibility = View.VISIBLE
        }
        image_title_dialog.setImageResource(imageTitle)
        btn_ok.visibility = visibilityButtonOk
        btn_cancel.visibility = visibilityButtonCancel
    }

    fun changeTextButtonOk(text: String){
        this.txtOkButton = text
    }

    fun changeTextButtonCancel(text: String){
        this.txtCancelButton = text
    }

}