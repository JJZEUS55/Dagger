package com.olimpo.av.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R

class MenuAdapter(var listMenu: List<MenuObject>) : RecyclerView.Adapter<MenuAdapter.MenuHolder>() {

    val countList: Int = listMenu.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        return MenuHolder(parent)
    }

    override fun getItemCount(): Int {
        return listMenu.count()
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        val title: MenuObject = listMenu[position]
        holder.bind(title)
    }

    fun update(items: List<MenuObject>) {
        this.listMenu = items
        notifyDataSetChanged()
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    inner class MenuHolder(
        val parent: ViewGroup,
        val binding: com.olimpo.av.databinding.ItemMenuBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_menu,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemMenu: MenuObject) = with(binding.root) {
            binding.itemMenu = itemMenu
            setOnClickListener {
                listMenu.forEach { menuObj ->
                    menuObj.visibility = false
                }
                itemMenu.visibility = true
                Toast.makeText(it.context, itemMenu.title + " " + itemMenu.visibility, Toast.LENGTH_SHORT).show()
            }
            binding.executePendingBindings()
        }
    }

    companion object {
        @BindingAdapter("adapter")
        @JvmStatic
        fun RecyclerView.bindItems(items: List<MenuObject>) {
            val adapter = adapter as MenuAdapter
            adapter.update(items)
        }
    }


}