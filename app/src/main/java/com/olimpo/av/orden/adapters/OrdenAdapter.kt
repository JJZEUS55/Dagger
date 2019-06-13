package com.olimpo.av.orden.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.olimpo.av.R
import com.olimpo.av.tables.adapters.BaseTableAdapter

class OrdenAdapter(context: Context) : BaseTableAdapter() {

    private val family: ArrayList<FamilyHeaders> = ArrayList()
    private val headers = listOf("Registro", "Representante", "Valor", "Remito", "Foto")
    private val widths = intArrayOf(120, 100, 140, 60, 70, 60, 60)
    private val density: Float = context.resources.displayMetrics.density
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    
    override fun getRowCount(): Int {
        return 14
    }

    override fun getColumnCount(): Int {
        return 6
    }

    override fun getViewTypeCount(): Int {
        return 5
    }

    init {
        family.add(FamilyHeaders("Mobiles"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
        family[0].list.add(OrdenInfo("12345678", "Blanca Rojas", "$2,045.00", "SI"))
    }

    override fun getView(row: Int, column: Int, convertView: View, parent: ViewGroup): View {
        val view: View
        when (getItemViewType(row, column)) {
            0 -> view = getFirstHeader(row, column, convertView, parent)
            1 -> view = getHeader(row, column, convertView, parent)
            2 -> view = getFirstBody(row, column, convertView, parent)
            3 -> view = getBody(row, column, convertView, parent)
            4 -> view = getFamilyView(row, column, convertView, parent)
            else -> throw RuntimeException("wtf?")
        }
        return view
    }

    private fun getFirstHeader(row: Int, column: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_table_header_first, parent, false)
        }
        (convertView?.findViewById<View>(android.R.id.text1) as TextView).text = headers[0]
        (convertView.findViewById<View>(android.R.id.text2) as TextView).text = headers[0]
        return convertView
    }

    private fun getHeader(row: Int, column: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_table_header, parent, false)
        }
        (convertView?.findViewById<View>(android.R.id.text1) as TextView).text = headers[column + 1]
        return convertView
    }

    private fun getFirstBody(row: Int, column: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_table_first, parent, false)
        }
        convertView?.setBackgroundResource(if (row % 2 == 0) R.drawable.bg_table_color1 else R.drawable.bg_table_color2)
        (convertView?.findViewById<View>(android.R.id.text1) as TextView).text = getDevice(row).data[column + 1]
        return convertView
    }

    private fun getBody(row: Int, column: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_table, parent, false)
        }
        convertView?.setBackgroundResource(if (row % 2 == 0) R.drawable.bg_table_color1 else R.drawable.bg_table_color2)
        (convertView?.findViewById<View>(android.R.id.text1) as TextView).text = getDevice(row).data[column + 1]
        return convertView
    }

    private fun getFamilyView(row: Int, column: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_table_family, parent, false)
        }
        val string: String
        if (column == -1) {
            string = getFamily(row).name
        } else {
            string = ""
        }
        (convertView?.findViewById<View>(android.R.id.text1) as TextView).text = string
        return convertView
    }

    override fun getWidth(column: Int): Int {
        return Math.round(widths[column + 1] * density)
    }

    override fun getHeight(row: Int): Int {
        val height: Int
        if (row == -1) {
            height = 35
        } else if (isFamily(row)) {
            height = 25
        } else {
            height = 45
        }
        return Math.round(height * density)
    }

    override fun getItemViewType(row: Int, column: Int): Int {
        val itemViewType: Int
        if (row == -1 && column == -1) {
            itemViewType = 0
        } else if (row == -1) {
            itemViewType = 1
        } else if (isFamily(row)) {
            itemViewType = 4
        } else if (column == -1) {
            itemViewType = 2
        } else {
            itemViewType = 3
        }
        return itemViewType
    }

    private fun isFamily(row: Int): Boolean {
        var row = row
        var family = 0
        while (row > 0) {
            row -= this.family[family].list.size + 1
            family++
        }
        return row == 0
    }

    private fun getFamily(row: Int): FamilyHeaders {
        var row = row
        var family = 0
        while (row >= 0) {
            row -= this.family[family].list.size + 1
            family++
        }
        return this.family[family - 1]
    }

    private fun getDevice(row: Int): OrdenInfo {
        var row = row
        var family = 0
        while (row >= 0) {
            row -= this.family[family].list.size + 1
            family++
        }
        family--
        return this.family[family].list[row + this.family[family].list.size]
    }
}

class FamilyHeaders(
    var name: String = "",
    var list: MutableList<OrdenInfo> = ArrayList()
)