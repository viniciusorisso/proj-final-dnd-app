package com.ficha.dd.domain.repository

import com.ficha.dd.domain.model.Item
import com.ficha.dd.util.Resource
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    // Flow -> 00:39:00
    suspend fun getItemsList(): Flow<Resource<List<Item>>>

    suspend fun getItemByIndex(index: String): Flow<Resource<Item>>
}