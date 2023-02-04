package com.ficha.dd.data.remote.dto

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