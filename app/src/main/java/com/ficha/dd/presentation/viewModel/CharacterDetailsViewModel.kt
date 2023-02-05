package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.CharacterAttributes
import kotlin.reflect.full.memberProperties

class CharacterDetailsViewModel : ViewModel() {

    private val _attributes = MutableLiveData<CharacterAttributes>()
    val attributes : LiveData<CharacterAttributes> = _attributes

    init {
        updateAttributes("strength", 0)
        updateAttributes("dexterity", 0)
        updateAttributes("constitution", 0)
        updateAttributes("intelligence", 0)
        updateAttributes("wisdom", 0)
        updateAttributes("charism", 0)
    }

    fun updateAttributes(attributeName: String, attributeValue: Int) {
        _attributes.value?.setAttributeValue(attributeName, attributeValue)
    }
}