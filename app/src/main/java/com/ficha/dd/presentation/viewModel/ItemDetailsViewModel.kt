package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.repository.ItemRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemDetailsViewModel(val repository: ItemRepository): ViewModel() {
    val itemDetails = MutableLiveData<Item?>()

    suspend fun updateItem(item: String) = withContext(Dispatchers.IO){
            repository.getItemByIndex(item).collect{
            when (it) {
                is Resource.Success -> {
                    if(it.data != null)
                        itemDetails.postValue(it.data)
                }
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
    }
}
