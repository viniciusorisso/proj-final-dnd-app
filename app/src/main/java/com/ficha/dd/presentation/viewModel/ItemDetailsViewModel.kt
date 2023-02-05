package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.repository.SpellRepository

class ItemDetailsViewModel(private val repository: SpellRepository): ViewModel() {
    private val _itemDetails = MutableLiveData<Item>()
    val itemDetails: LiveData<Item> = _itemDetails

    fun updateItem(item: Item) {
        _itemDetails.value = item
    }
}
