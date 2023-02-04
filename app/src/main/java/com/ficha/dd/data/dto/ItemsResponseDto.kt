package com.ficha.dd.data.dto

import com.ficha.dd.data.dto.ResponseItemDto.ItemDto
import com.squareup.moshi.Json

data class ItemsResponseDto (
    val count: Int,
    @Json(name = "results")
    val itemsList: List<ItemDto>
)