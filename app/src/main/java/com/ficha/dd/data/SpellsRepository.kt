package com.ficha.dd.data

import com.ficha.dd.data.dao.SpellDAO
import com.ficha.dd.data.dto.toSpell
import com.ficha.dd.domain.toModel

class SpellsRepository (
    val api: DndApi,
) {
    suspend fun getAllSpells(dao: SpellDAO) {
        val spellsList = api.getAllSpells().spellsList.map { spellDto ->
            spellDto.toSpell()
        }
        spellsList.map { spell ->
            dao.insert(spell.toModel())
        }
    }
}