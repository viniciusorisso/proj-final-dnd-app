package com.ficha.dd.data

import com.ficha.dd.domain.CharacterSheet

interface CharacterSheetApi {
    fun getSheetById(id: Int): CharacterSheet;
    fun getAllSheets(): List<CharacterSheet>;
}
