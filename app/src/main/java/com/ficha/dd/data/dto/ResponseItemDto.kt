package com.ficha.dd.data.dto

import com.ficha.dd.domain.Element.Item
import com.ficha.dd.domain.Element.Spell
import com.squareup.moshi.Json

@Json
sealed class ResponseItemDto (
    val index: String,
    val name: String,
    val url: String,
){
    class ItemDto(index : String, name : String, url : String): ResponseItemDto(index, name, url)
    class SpellDto(index : String, name : String, url : String): ResponseItemDto(index, name, url)
}

fun ResponseItemDto.ItemDto.toItem() = Item(
    index = index,
    name = name,
    url = url,
    damage = null,
    range = null
)
fun ResponseItemDto.SpellDto.toSpell() = Spell(
    index = index,
    name = name,
    url = url,
    damage = null,
    description = null
)