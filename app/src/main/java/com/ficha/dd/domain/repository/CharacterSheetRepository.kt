package com.ficha.dd.domain.repository

import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterSheetRepository {
    suspend fun getCharactersSheetList(): Flow<Resource<List<CharacterSheet>>>

    suspend fun getCharacterSheetById(id: Int): Flow<Resource<CharacterSheet>>

    suspend fun pushNewCharacterSheet(characterSheet: CharacterSheet): Flow<Resource<Boolean>>

//    suspend fun pushNewCharacterSpell(spell: Spell): Flow<Resource<Boolean>>
//
//    suspend fun removeCharacterSpell(index: String): Flow<Resource<Boolean>>
//
//    suspend fun pushNewCharacterItem(item: Item): Flow<Resource<Boolean>>
//
//    suspend fun removeCharacterItem(index: String): Flow<Resource<Boolean>>
}