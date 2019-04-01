package com.olimpo.av.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R
import java.util.zip.Inflater

class RVMenu(private val listMenu : List<String>) : RecyclerView.Adapter<RVMenu.MenuHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder{
        val inflateView = parent.inflate(R.layout.row_menu, false)
        return MenuHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return listMenu.count()
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        val title : String = listMenu[position]
        holder.txtValMenu.text = title
        if (position == 0)
            holder.viewIsPressed.visibility = View.VISIBLE

        if(position == itemCount - 1)
            holder.viewBottom.visibility = View.VISIBLE

    }

    class MenuHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var txtValMenu : TextView
        lateinit var viewIsPressed : View
        lateinit var viewBottom : View

        init {
            txtValMenu = itemView.findViewById(R.id.txt_val_menu)
            viewIsPressed = itemView.findViewById(R.id.view_is_pressed)
            viewBottom = itemView.findViewById(R.id.view_bottom)
        }

    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }
}