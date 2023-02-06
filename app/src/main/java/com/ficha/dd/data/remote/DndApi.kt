package com.ficha.dd.data.remote

import com.ficha.dd.data.remote.dto.ItemsListResponseDto
import com.ficha.dd.data.remote.dto.SpellsListResponseDto
import com.ficha.dd.data.remote.dto.ItemResponseDto
import com.ficha.dd.data.remote.dto.SpellResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DndApi {
    @GET("equipment/{index}")
    suspend fun getItemByIndex(@Path("index") index: String): ItemResponseDto;
//    fun getSpellByIndex(index: String): Element.Spell;
    @GET("equipment/")
    suspend fun getAllItems(): ItemsListResponseDto;
//
    @GET("spells/{index}")
    suspend fun getSpellByIndex(@Path("index") index: String): SpellResponseDto;
    @GET("spells/")
    suspend fun getAllSpells(): SpellsListResponseDto;

    companion object {
        const val BASE_URL = "https://www.dnd5eapi.co/api/"
    }
}
