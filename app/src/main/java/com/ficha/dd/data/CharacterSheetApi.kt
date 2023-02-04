package com.ficha.dd.data

import com.ficha.dd.domain.CharacterSheet

const val BASE_URL = "https://www.dnd5eapi.co/api/"

interface CharacterSheetApi {
    fun getSheetById(id: Int): CharacterSheet;
    fun getAllSheets(): List<CharacterSheet>;
}
