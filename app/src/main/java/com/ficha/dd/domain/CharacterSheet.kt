package com.ficha.dd.domain

import com.ficha.dd.domain.Element.Item
import com.ficha.dd.domain.Element.Spell

data class CharacterSheet (
    val name: String,
    val level: Int,
    val classy: String,
    val spellsList: List<Spell>?,
    val itemsList: List<Item>?,
)