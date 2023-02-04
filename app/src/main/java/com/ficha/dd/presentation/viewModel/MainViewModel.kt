package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.domain.repository.CharacterSheetRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(val repository: CharacterSheetRepository) : ViewModel() {
    private val _allSheets = MutableLiveData<List<CharacterSheet>?>()
    val allSheets: LiveData<List<CharacterSheet>?> = _allSheets

    init {
        viewModelScope.launch {
            loadInfo()
        }
    }

    suspend fun loadInfo() {
//        repository.pushNewCharacterSheet(
//            CharacterSheet(
//                0, "Joao", 12, null, null
//            )
//        ).collect{
//            when (it) {
//                is Resource.Success -> {}
//                is Resource.Error -> {}
//                is Resource.Loading -> {}
//            }
//        }
        return repository.getCharactersSheetList().collect {
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