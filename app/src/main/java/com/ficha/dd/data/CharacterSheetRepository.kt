package com.ficha.dd.data

import com.ficha.dd.domain.CharacterSheet

class CharacterSheetRepository (
    val api: CharacterSheetApi
) {
    fun getAllCharactersSheet(): List<CharacterSheet> {
        return api.getAllSheets()
    }
}