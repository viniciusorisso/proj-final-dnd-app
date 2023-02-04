package com.ficha.dd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.data.CharacterSheetRepository
import com.ficha.dd.domain.CharacterSheet

class MainViewModel(val repository: CharacterSheetRepository) : ViewModel() {
    private val _allSheets = MutableLiveData<List<CharacterSheet>>()
    val allSheets: LiveData<List<CharacterSheet>> = _allSheets

    init {
        loadInfo()
    }

    fun loadInfo() {
        _allSheets.value = repository.getAllCharactersSheet()
    }
}