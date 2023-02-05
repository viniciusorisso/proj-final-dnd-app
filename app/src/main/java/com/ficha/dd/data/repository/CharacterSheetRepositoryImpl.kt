package com.ficha.dd.data.repository

import com.ficha.dd.data.mapper.toCharacterSheet
import com.ficha.dd.data.mapper.toCharacterSheetEntity
import com.ficha.dd.data.room.DndDatabase
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.CharacterSheetRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class CharacterSheetRepositoryImpl (
    db: DndDatabase
): CharacterSheetRepository {
    private val dao = db.CharacterSheetDAO()

    override suspend fun getCharactersSheetList(): Flow<Resource<List<CharacterSheet>>> =
        withContext(Dispatchers.IO) {
            return@withContext flow {
                emit(Resource.Loading(true))
                val charactersList = dao.getAllCharactersSheet()
                emit(Resource.Success(
                    data = charactersList.map { it.toCharacterSheet() }
                ))
                val isDbEmpty = charactersList.isEmpty()
                if(!isDbEmpty){
                    emit(Resource.Loading(false))
                    return@flow
                }
                else {
                    emit(Resource.Error("Não foi possível carregar a lista de Fichas"))
                    null
                }
            }
    }

    override suspend fun getCharacterSheetById(id: Int): Flow<Resource<CharacterSheet>> =
        withContext(Dispatchers.IO) {
            return@withContext flow {
                // Emit 00:42:00
                emit(Resource.Loading(true))
                val charactersList = dao.getCharacterById(id)
                emit(Resource.Success(
                    data = charactersList.toCharacterSheet()
                ))
                emit(Resource.Loading(false))
            }
    }

    override suspend fun pushNewCharacterSheet(characterSheet: CharacterSheet): Flow<Resource<Boolean>> =
        withContext(Dispatchers.IO) {
            return@withContext flow {
                emit(Resource.Loading(true))
                dao.insertCharacterSheet(characterSheet.toCharacterSheetEntity())
                emit(Resource.Success(
                    data = true
                ))
                emit(Resource.Loading(false))
            }
        }

//    override suspend fun pushNewCharacterSpell(spell: Spell): Flow<Resource<Boolean>> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun removeCharacterSpell(index: String): Flow<Resource<Boolean>> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun pushNewCharacterItem(item: Item): Flow<Resource<Boolean>> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun removeCharacterItem(index: String): Flow<Resource<Boolean>> {
//        TODO("Not yet implemented")
//    }
}