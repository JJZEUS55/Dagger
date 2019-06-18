package com.olimpo.av.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var lstLivePoll: LiveData<List<QuestItem>> = MutableLiveData<List<QuestItem>>().apply {
        val list: MutableList<QuestItem> = ArrayList()

        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))
        list.add(QuestItem(1, "NO HIZO BIEN SU CHAMBA"))

        value = list
    }
}