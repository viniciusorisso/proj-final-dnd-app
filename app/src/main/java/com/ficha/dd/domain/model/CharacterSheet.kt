package com.ficha.dd.domain.model

class CharacterSheet (
    var id: Int,
    var name : String,
    var level: Int?,
    var spellsList: List<Spell>?,
    var itemsList: List<Item>?
)