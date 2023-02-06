package com.ficha.dd.data.mapper

import com.ficha.dd.data.remote.dto.item_response.ItemCostDto
import com.ficha.dd.domain.model.ItemCost

fun ItemCostDto.toCost(): ItemCost {
    return ItemCost(
        quantity = quantity,
        unit = unit
    )
}