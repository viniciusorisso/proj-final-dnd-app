package com.ficha.dd.data.mapper

import com.ficha.dd.data.local.SpellEntity
import com.ficha.dd.data.remote.dto.ResponseItemDto
import com.ficha.dd.data.remote.dto.SpellResponseDto
import com.ficha.dd.domain.model.Spell

fun SpellEntity.toSpell(): Spell {
    return Spell(
        index = spellIndex,
        name = name,
        url = url,
        desc = null,
        level = null,
        attack_type = null,
        duration = null,
        range = null,
        casting_time = null,
    )
}
fun Spell.toSpellEntity(): SpellEntity {
    return SpellEntity(
        spellIndex = index,
        name = name,
        url = url,
    )
}
fun ResponseItemDto.SpellDto.toSpellEntity(): SpellEntity {
    return SpellEntity(
        spellIndex = index,
        name = name,
        url = url
    )
}
fun ResponseItemDto.SpellDto.toSpell(): Spell {
    return Spell(
        index = index,
        name = name,
        url = url,
        desc = null,
        level = null,
        attack_type = null,
        duration = null,
        range = null,
        casting_time = null,
    )
}
fun SpellResponseDto.toSpell(): Spell {
    return Spell(
        index = spellIndex,
        name = name,
        url = url,
        level = level,
        desc = desc,
        attack_type = attack_type,
        duration = duration,
        range = range,
        casting_time = casting_time,
    )
}