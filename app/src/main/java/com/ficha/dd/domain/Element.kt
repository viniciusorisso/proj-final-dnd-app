package com.ficha.dd.domain

import com.ficha.dd.data.model.ItemModel
import com.ficha.dd.data.model.SpellModel

sealed class Element (
    val index: String,
    val name: String,
    val url: String,
){
    class Item(index : String, name : String, url : String, val damage: String?, val range: String?) : Element(index, name, url)
    class Spell(index : String, name : String, url : String, val damage: String?, val description: String?) : Element(index, name, url)
}

fun Element.Item.toModel() = ItemModel(
    index = index,
    name = name,
    url = url,
)

fun Element.Spell.toModel() = SpellModel(
    index = index,
    name = name,
    url = url,
)