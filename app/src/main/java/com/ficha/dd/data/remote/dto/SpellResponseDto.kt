package com.ficha.dd.data.remote.dto

import com.ficha.dd.data.remote.dto.spell_response.*
import com.squareup.moshi.Json

data class SpellResponseDto (
    @Json(name="index")
   val spellIndex: String,
    val name: String,
    val url: String,
    val desc: List<String>?,
    val higher_level: List<String>?,
    val range: String?,
    val components: List<SpellComponentsTypes>?,
    val material: String?,
    val area_of_effect: Any?,
    val ritual: Boolean?,
    val duration: String?,
    val concentration: Boolean?,
    val casting_time: String?,
    val level: Int?,
    val attack_type: String?,
    val school: SpellSchoolDto?,
    val classes: List<SpellClassesDto>?,
    val subclasses: List<SpellSubClassesDto>?,
    val damage: Any?,
)
