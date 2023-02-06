package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.SpellRepository

class SpellDetailsViewModel(): ViewModel() {
    private val _spellDetails = MutableLiveData<Spell>()
    val spellDetails: LiveData<Spell> = _spellDetails

    fun updateItem(spell: Spell) {
        _spellDetails.value = spell
    }
}
