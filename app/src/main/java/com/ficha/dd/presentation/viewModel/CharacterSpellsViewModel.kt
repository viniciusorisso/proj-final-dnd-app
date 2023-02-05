package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.CharacterSheetRepository

class CharacterSpellsViewModel(private val repository: CharacterSheetRepository) : ViewModel() {
    private val _allSpells = MutableLiveData<List<Spell>?>()
    val allSpells: LiveData<List<Spell>?> = _allSpells

    init {
        updateSpellList(null)
    }
    fun updateSpellList(spellsList: List<Spell>?) {
        if(!spellsList.isNullOrEmpty())
            _allSpells.value = spellsList
        else
            _allSpells.value = listOf(Spell("acid", "acid", "acid"))
    }
}