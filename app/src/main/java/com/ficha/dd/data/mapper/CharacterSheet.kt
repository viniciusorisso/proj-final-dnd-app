package com.ficha.dd.data.mapper

import com.ficha.dd.data.local.CharacterSheetEntity
import com.ficha.dd.domain.model.CharacterSheet

fun CharacterSheetEntity.toCharacterSheet(): CharacterSheet {
    return CharacterSheet(
        id = id,
        name = name,
        level = level,
        spellsList = spellsList,
        itemsList = itemsList
    )
}
fun CharacterSheet.toCharacterSheetEntity(): CharacterSheetEntity {
    return CharacterSheetEntity(
        id = id,
        name = name,
        level = level,
        spellsList = spellsList,
        itemsList = itemsList
    )
}