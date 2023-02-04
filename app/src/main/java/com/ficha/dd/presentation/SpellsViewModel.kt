package com.ficha.dd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ficha.dd.data.SpellsRepository
import com.ficha.dd.domain.Element
import com.ficha.dd.domain.Element.Spell
import kotlinx.coroutines.launch

class SpellsViewModel(val repository: SpellsRepository) : ViewModel() {
    private val _allSpells = MutableLiveData<List<Spell>>()
    val allSpells: LiveData<List<Spell>> = _allSpells

    init {
        viewModelScope.launch{
            loadInfo()
        }
    }

    suspend fun loadInfo() {
        repository.getAllSpells()
//        _allSpells.value =
    }
}