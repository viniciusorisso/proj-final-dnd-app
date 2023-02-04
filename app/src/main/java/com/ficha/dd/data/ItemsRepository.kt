package com.ficha.dd.data

import com.ficha.dd.data.dto.toItem
import com.ficha.dd.domain.Element.Item

class ItemsRepository (
    val api: DndApi
) {
    suspend fun getAllItems(): List<Item> {
        return api.getAllItems().itemsList.map{
            itemDto -> itemDto.toItem()
        }
    }
}