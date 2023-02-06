package com.ficha.dd.domain.repository

import com.ficha.dd.domain.model.Spell
import com.ficha.dd.util.Resource
import kotlinx.coroutines.flow.Flow

interface SpellRepository {
    // Flow -> 00:39:00
    suspend fun getSpellsList(): Flow<Resource<List<Spell>>>

    suspend fun getSpellByIndex(index: String): Flow<Resource<Spell>>
}