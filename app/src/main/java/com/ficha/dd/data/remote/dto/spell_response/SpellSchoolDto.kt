package com.ficha.dd.data.remote.dto.spell_response

import com.squareup.moshi.Json

data class SpellSchoolDto (
    @Json(name="index")
    val spellSchoolIndex: String,
    val name: String,
    val url:String,
)
