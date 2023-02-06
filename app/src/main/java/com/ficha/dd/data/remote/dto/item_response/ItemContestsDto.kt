package com.ficha.dd.data.remote.dto.item_response

import com.squareup.moshi.Json

data class ItemContentDto (
    @Json(name="index")
    val contentIndex: String,
    val name: String,
    val url: String
)


