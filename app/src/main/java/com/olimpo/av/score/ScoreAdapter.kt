package com.olimpo.av.score

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.olimpo.av.R

class ScoreAdapter(var list: List<QuestItem>): RecyclerView.Adapter<ScoreAdapter.ViewHolder>(){

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

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var cbQuest: CheckBox = itemView.findViewById(R.id.cb_quest)

        fun bind(item: QuestItem){
            cbQuest.text = item.text
        }
    }
}