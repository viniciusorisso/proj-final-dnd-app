package com.ficha.dd.presentation.ui.item_details

import androidx.constraintlayout.widget.ConstraintLayout
import com.ficha.dd.domain.model.Item

class ItemDetailsAdapter{
    private var _item: Item? = null
    private val item: Item? = _item

    init {
        setItem(null)
    }

    fun setItem(item: Item?){
        _item = item
    }

}
