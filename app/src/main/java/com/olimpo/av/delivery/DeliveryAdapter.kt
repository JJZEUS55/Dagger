package com.olimpo.av.delivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R
import com.olimpo.av.unit.DeliveryItem

class DeliveryAdapter(var list: List<DeliveryItem>): RecyclerView.Adapter<DeliveryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = parent.inflate(R.layout.item_table_order, false)
        return ViewHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDeliveryItem: DeliveryItem = list[position]
        holder.bind(itemDeliveryItem)
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCode: TextView = itemView.findViewById(R.id.txt_code)
        var txtDescription: TextView = itemView.findViewById(R.id.txt_description)
        var txtQuantity: TextView = itemView.findViewById(R.id.txt_quantity)

        fun bind(item: DeliveryItem){
            txtCode.text = item.code.toString()
            txtDescription.text = item.description
            txtQuantity.text = item.quantity.toString()
        }
    }
}