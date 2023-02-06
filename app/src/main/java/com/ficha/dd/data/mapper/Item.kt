package com.ficha.dd.data.mapper

import com.ficha.dd.data.local.ItemEntity
import com.ficha.dd.data.remote.dto.ItemResponseDto
import com.ficha.dd.data.remote.dto.ResponseItemDto
import com.ficha.dd.domain.model.Item

fun ItemEntity.toItem(): Item {
    return Item(
        index = itemIndex,
        name = name,
        url = url,
        desc = null,
        itemCost = null,
    )
}
fun Item.toItemEntity(): ItemEntity {
    return ItemEntity(
        itemIndex = index,
        name = name,
        url = url
    )
}
fun ResponseItemDto.ItemDto.toItemEntity(): ItemEntity {
    return ItemEntity(
        itemIndex = index,
        name = name,
        url = url
    )
}
fun ResponseItemDto.ItemDto.toItem(): Item {
    return Item(
        index = index,
        name = name,
        url = url,
        desc = null,
        itemCost = null,
    )
}
fun ItemResponseDto.toItem(): Item {
    return Item(
        index = itemIndex,
        name = name,
        url = url,
        desc = desc,
        itemCost = cost.toCost(),
    )
}