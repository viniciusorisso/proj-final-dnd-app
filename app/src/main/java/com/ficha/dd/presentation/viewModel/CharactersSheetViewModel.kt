package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.CharacterSheetRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersSheetViewModel  (val repository: CharacterSheetRepository) : ViewModel() {
    private val _allSheets = MutableLiveData<List<CharacterSheet>?>()
    val allSheets: LiveData<List<CharacterSheet>?> = _allSheets

    init {
        viewModelScope.launch {
            loadInfo()
        }
    }

    suspend fun loadInfo() = withContext(Dispatchers.IO) {
        val spellList: List<Spell> = listOf(Spell("acid-arrow", "Acid Arrow", "url"), Spell("acid-arrow", "Acid Arrow", "url"))

        repository.pushNewCharacterSheet(
            CharacterSheet(
                0, "Joao", 12, spellList, null
            )
        ).collect{
            when (it) {
                is Resource.Success -> {}
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
        repository.getCharactersSheetList().collect {
            when (it) {
                is Resource.Success -> {
                    _allSheets.postValue(it.data)
                }
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
    }
}