package com.ficha.dd.data.remote.dto.item_response

import com.squareup.moshi.Json

data class ItemGearCategoryDto (
    @Json(name="index")
    val gearIndex: String,
    val name: String,
    val url: String,
)
