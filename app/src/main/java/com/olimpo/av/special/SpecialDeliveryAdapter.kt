package com.olimpo.av.special

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.AgentObject
import com.olimpo.av.R

class SpecialDeliveryAdapter(var list: List<AgentObject>): RecyclerView.Adapter<SpecialDeliveryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = parent.inflate(R.layout.item_special_delivery, false)
        return ViewHolder(inflateView)
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: AgentObject = list[position]
        holder.bind(item)
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        private val txtNameAgent: TextView = itemView.findViewById(R.id.txt_name_agent)
        private val txtRegister: TextView = itemView.findViewById(R.id.txt_register)
        private val txtZone: TextView = itemView.findViewById(R.id.txt_zone)
        private val txtStatus: TextView = itemView.findViewById(R.id.txt_status)

        fun bind(item: AgentObject){
            txtNameAgent.text = item.name
            txtRegister.append(item.register.toString())
            txtZone.append(item.zone.toString())
            txtStatus.append(item.status)
        }
    }
}