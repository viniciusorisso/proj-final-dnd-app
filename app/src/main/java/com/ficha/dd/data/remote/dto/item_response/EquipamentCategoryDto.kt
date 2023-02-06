package com.ficha.dd.data.remote.dto.item_response

import com.squareup.moshi.Json

data class EquipmentCategoryDto (
    @Json(name="index")
    val equipmentIndex: String,
    val name: String,
    val url: String,
)