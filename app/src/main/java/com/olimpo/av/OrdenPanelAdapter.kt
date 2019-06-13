package com.olimpo.av

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.kelin.scrollablepanel.library.PanelAdapter

class OrdenPanelAdapter : PanelAdapter() {
    private lateinit var data: List<List<OrderInfo>>

    override fun getRowCount(): Int {
        return data.size
    }

    fun setList(lst: List<List<OrderInfo>>){
        data = lst
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val inflateView = parent!!.inflate(R.layout.table_header, false)
        return TitleViewHolder(inflateView)
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, row: Int, column: Int) {
        val title = data[row][column]
        val titleViewHolder = holder as TitleViewHolder
        titleViewHolder.txtTitle.text = title.id.toString()
    }

    override fun getColumnCount(): Int {
        return data[0].size
    }


    inner class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitle: TextView = view.findViewById(R.id.txt_title)
    }

}