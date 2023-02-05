package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.repository.CharacterSheetRepository

class CharacterItemsViewModel(private val repository: CharacterSheetRepository) : ViewModel() {
    private val _allItems = MutableLiveData<List<Item>?>()
    val allItems: LiveData<List<Item>?> = _allItems

    init {
        updateItemList(null)
    }
    fun updateItemList(itemsList: List<Item>?) {
        if(!itemsList.isNullOrEmpty())
            _allItems.value = itemsList
        else
            _allItems.value = listOf(Item("acid", "acid", "acid"))
    }
}