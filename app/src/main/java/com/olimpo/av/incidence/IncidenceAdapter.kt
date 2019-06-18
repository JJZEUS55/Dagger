package com.olimpo.av.incidence

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R
import com.olimpo.av.score.QuestItem
import kotlinx.android.synthetic.main.item_quest.view.*

class IncidenceAdapter(var list: List<QuestItem>) : RecyclerView.Adapter<IncidenceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = parent.inflate(R.layout.item_quest, false)
        return ViewHolder(inflateView)
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: QuestItem = list[position]
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cbQuest: CheckBox = itemView.findViewById(R.id.cb_quest)

        fun bind(item: QuestItem) {
            cbQuest.text = item.text
        }
    }
}