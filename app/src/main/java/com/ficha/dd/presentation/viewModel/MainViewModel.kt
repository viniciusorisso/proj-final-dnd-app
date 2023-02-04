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

class MainViewModel(private val repository: CharacterSheetRepository) : ViewModel(){
    private val _character = MutableLiveData<CharacterSheet>()
    val character: LiveData<CharacterSheet> = _character

    fun updateCharacter(character: CharacterSheet) {
        _character.value = character
    }
}