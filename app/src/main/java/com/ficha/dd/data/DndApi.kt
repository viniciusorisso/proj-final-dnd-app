package com.ficha.dd.data

import com.ficha.dd.data.dto.ItemsResponseDto
import com.ficha.dd.data.dto.SpellsResponseDto
import com.ficha.dd.domain.Element
import retrofit2.http.GET

interface DndApi {
//    fun getItemByIndex(index: String): Element.Item;
//    fun getSpellByIndex(index: String): Element.Spell;
    @GET("equipment/")
    suspend fun getAllItems(): ItemsResponseDto;
    @GET("spells/")
    suspend fun getAllSpells(): SpellsResponseDto;
}
