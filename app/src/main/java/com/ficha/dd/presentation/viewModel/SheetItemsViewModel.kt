package com.ficha.dd.presentation.viewModel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.repository.ItemRepository
import com.ficha.dd.presentation.ui.item_details.ItemDetailsActivity
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SheetItemsViewModel(private val repository: ItemRepository) : ViewModel() {
    private val _allItems = MutableLiveData<List<Item>?>()
    val allItems: LiveData<List<Item>?> = _allItems

    init {
        viewModelScope.launch {
            loadInfo()
        }
    }
    suspend fun loadInfo() = withContext(Dispatchers.IO){
        repository.getItemsList().collect{
            when (it) {
                is Resource.Success -> {
                    _allItems.postValue(it.data)
                }
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
    }

    fun newIntent(context: Context): Intent {
        var newIntent = Intent(context, ItemDetailsActivity ::class.java)
        return newIntent
    }
}