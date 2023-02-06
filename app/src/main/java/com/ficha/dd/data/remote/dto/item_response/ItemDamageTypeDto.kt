package com.ficha.dd.data.remote.dto.item_response

import com.squareup.moshi.Json

data class ItemDamageTypeDto (
    @Json(name="index")
    val itemDamageIndex: String,
    val name: String,
    val url: String,
)
