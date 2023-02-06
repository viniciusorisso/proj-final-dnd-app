package com.ficha.dd.domain.repository

import com.ficha.dd.data.remote.dto.ItemResponseDto
import com.ficha.dd.domain.model.Item
import com.ficha.dd.util.Resource
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun getItemsList(): Flow<Resource<List<Item>>>

    suspend fun getItemByIndex(index: String): Flow<Resource<Item>>
}