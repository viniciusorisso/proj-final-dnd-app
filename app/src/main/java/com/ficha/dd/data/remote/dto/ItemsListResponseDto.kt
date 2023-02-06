package com.ficha.dd.data.remote.dto

import com.ficha.dd.data.remote.dto.ResponseItemDto.ItemDto
import com.squareup.moshi.Json

data class ItemsListResponseDto (
    val count: Int,
    @Json(name = "results")
    val itemsList: List<ItemDto>
)