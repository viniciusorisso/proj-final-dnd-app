package com.ficha.dd.data.remote.dto.spell_response

import com.squareup.moshi.Json

data class SpellClassesDto (
    @Json(name="index")
    val spellClassesIndex: String,
    val name: String,
    val url:String,
)
