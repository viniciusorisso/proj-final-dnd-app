package com.ficha.dd.data

import com.ficha.dd.domain.CharacterSheet

class CharacterSheetApiFake : CharacterSheetApi {
    override fun getSheetById(id: Int): CharacterSheet {
        TODO("Not yet implemented")
    }

    override fun getAllSheets(): List<CharacterSheet> {
        return listOf<CharacterSheet>(
            CharacterSheet("Kramex", 7, "Ranger", emptyList(), emptyList()),
            CharacterSheet("Aussyrk", 8, "Bard", emptyList(), emptyList()),
        )
    }
}