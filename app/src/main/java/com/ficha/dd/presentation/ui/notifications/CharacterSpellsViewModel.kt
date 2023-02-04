package com.ficha.dd.presentation.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.CharacterSheetRepository

class CharacterSpellsViewModel(private val repository: CharacterSheetRepository) : ViewModel() {
    private val _allSpells = MutableLiveData<List<Spell>?>()
    val allSpells: LiveData<List<Spell>?> = _allSpells

    fun updateSpellList(spellsList: List<Spell>?) {
        if(!spellsList.isNullOrEmpty()){
            _allSpells.value = spellsList
        }
    }
}