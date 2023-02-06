package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.SpellRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpellDetailsViewModel(val repository: SpellRepository): ViewModel() {
    val spellDetails = MutableLiveData<Spell?>()

    suspend fun updateSpell(item: String) = withContext(Dispatchers.IO){
        repository.getSpellByIndex(item).collect{
            when (it) {
                is Resource.Success -> {
                    if(it.data != null)
                        spellDetails.postValue(it.data)
                }
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
    }
}
