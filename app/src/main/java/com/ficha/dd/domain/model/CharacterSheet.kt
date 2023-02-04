package com.ficha.dd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CharacterSheet (
    var id: Int,
    var name : String,
    var level: Int?,
    var spellsList: List<Spell>?,
    var itemsList: List<Item>?
) : Parcelable