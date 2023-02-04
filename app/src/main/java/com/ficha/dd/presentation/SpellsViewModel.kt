package com.ficha.dd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.SpellRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpellsViewModel(val repository: SpellRepository) : ViewModel() {
    private val _allSpells = MutableLiveData<List<Spell>?>()
    val allSpells: LiveData<List<Spell>?> = _allSpells

    init {
        viewModelScope.launch{
            loadInfo()
        }
    }

    suspend fun loadInfo() = withContext(Dispatchers.IO) {repository.getSpellsList().collect{
            when (it) {
                is Resource.Success -> {
                    _allSpells.postValue(it.data)
                }
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
    }
}