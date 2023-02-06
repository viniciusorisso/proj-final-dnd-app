package com.ficha.dd.data.remote.dto.spell_response

import com.squareup.moshi.Json

data class SpellSubClassesDto (
    @Json(name="index")
    val spellSubClassesIndex: String,
    val name: String,
    val url:String,
)