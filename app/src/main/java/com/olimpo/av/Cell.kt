package com.olimpo.av

import com.evrencoskun.tableview.filter.IFilterableModel
import com.evrencoskun.tableview.sort.ISortableModel

open class Cell : ISortableModel, IFilterableModel {

    private var mId: String? = null
    var data: Any? = null
        private set
    var filterKeyword: String? = null

    constructor(id: String) {
        this.mId = id
    }

    constructor(id: String, data: Any) {
        this.mId = id
        this.data = data
        this.filterKeyword = data.toString()
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    override fun getId(): String? {
        return mId
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    override fun getContent(): Any? {
        return data
    }

    fun setData(data: String) {
        this.data = data
    }

    override fun getFilterableKeyword(): String? {
        return filterKeyword
    }
}