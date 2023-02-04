package com.ficha.dd.data.remote.dto

import com.ficha.dd.data.remote.dto.ResponseItemDto.SpellDto
import com.squareup.moshi.Json

data class SpellsResponseDto (
    val count: Int,
    @Json(name = "results")
    val spellsList: List<SpellDto>
)