package com.ficha.dd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ficha.dd.data.repository.ItemsRepository
import com.ficha.dd.domain.model.Item
import kotlinx.coroutines.launch

class ItemsViewModel(val repository: ItemsRepository) : ViewModel() {
    private val _allItems = MutableLiveData<List<Item>>()
    val allItems: LiveData<List<Item>> = _allItems

    init {
        viewModelScope.launch {
            loadInfo()
        }

    }

    suspend fun loadInfo() {
        _allItems.value = repository.getAllItems()
    }
}