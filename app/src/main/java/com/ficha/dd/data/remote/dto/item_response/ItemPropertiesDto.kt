package com.ficha.dd.data.remote.dto.item_response

import com.squareup.moshi.Json

data class ItemPropertiesDto (
    @Json(name="index")
    val propertiesIndex: String,
    val name: String,
    val url: String,
)
