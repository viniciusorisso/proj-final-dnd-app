package com.ficha.dd.data.dto

import com.ficha.dd.data.dto.ResponseItemDto.SpellDto
import com.squareup.moshi.Json

data class SpellsResponseDto (
    val count: Int,
    @Json(name = "results")
    val spellsList: List<SpellDto>
)