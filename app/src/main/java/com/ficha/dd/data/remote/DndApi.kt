package com.ficha.dd.data.remote

import com.ficha.dd.data.remote.dto.ItemsResponseDto
import com.ficha.dd.data.remote.dto.SpellsResponseDto
import retrofit2.http.GET

interface DndApi {
//    fun getItemByIndex(index: String): Element.Item;
//    fun getSpellByIndex(index: String): Element.Spell;
    @GET("equipment/")
    suspend fun getAllItems(): ItemsResponseDto;
//
//    @GET("equipment/")
//    suspend fun getItemByIndex(): ItemsResponseDto;
    @GET("spells/")
    suspend fun getAllSpells(): SpellsResponseDto;

    companion object {
        const val BASE_URL = "https://www.dnd5eapi.co/api/"
    }
}
