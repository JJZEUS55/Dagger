package com.olimpo.av.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.MenuObject
import com.olimpo.av.R

class RVMenu(var listMenu: List<MenuObject>) : RecyclerView.Adapter<RVMenu.MenuHolder>() {

    val countList: Int = listMenu.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        val inflateView = parent.inflate(R.layout.row_menu, false)
        return MenuHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return listMenu.count()
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        val title: MenuObject = listMenu[position]
        holder.bind(title)
    }

    fun resetFlags(){
        for (itemMenu in listMenu){
            itemMenu.visibility = View.GONE
        }
        notifyDataSetChanged()
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    inner class MenuHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtValMenu: TextView = itemView.findViewById(R.id.txt_val_menu)
        var viewIsPressed: View = itemView.findViewById(R.id.view_is_pressed)
        var viewBottom: View = itemView.findViewById(R.id.view_bottom)

        fun bind(item: MenuObject) {
            txtValMenu.text = item.title
            viewIsPressed.visibility = View.GONE

            if (layoutPosition == 0)
                viewIsPressed.visibility = View.VISIBLE

//            if (layoutPosition == itemCount - 1)
//                viewBottom.visibility = View.VISIBLE

            txtValMenu.setOnClickListener {
                resetFlags()
                viewIsPressed.visibility = View.VISIBLE
            }
        }

    }


}