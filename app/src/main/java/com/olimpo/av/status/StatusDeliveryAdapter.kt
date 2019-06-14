package com.olimpo.av.status

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R
import com.olimpo.av.unit.StatusDelivery

class StatusDeliveryAdapter(var list: List<StatusDelivery>) : RecyclerView.Adapter<StatusDeliveryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = parent.inflate(R.layout.item_status_order, false)
        return ViewHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val statusDelivery: StatusDelivery = list[position]
        holder.bind(statusDelivery)
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtTitle: TextView = itemView.findViewById(R.id.txt_title_status)
        var txtHour: TextView = itemView.findViewById(R.id.txt_hour_status)
        var txtDate: TextView = itemView.findViewById(R.id.txt_date_status)
        var imgChecked: AppCompatImageView = itemView.findViewById(R.id.checked_status)

        fun bind(statusDelivery: StatusDelivery){
            txtTitle.text = statusDelivery.titleStatus
            txtHour.text = statusDelivery.hour
            txtDate.text = statusDelivery.date
            imgChecked.visibility = statusDelivery.visibility
        }

    }


}