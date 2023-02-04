package com.ficha.dd.data.repository

import com.ficha.dd.data.mapper.toItem
import com.ficha.dd.data.mapper.toItemEntity
import com.ficha.dd.data.remote.DndApi
import com.ficha.dd.data.room.DndDatabase
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.repository.ItemRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

class ItemRepositoryImpl(
    val api: DndApi,
    db: DndDatabase
): ItemRepository {
    private val dao = db.ItemDAO()

    override suspend fun getItemsList(): Flow<Resource<List<Item>>> =
        withContext(Dispatchers.IO) {
            return@withContext flow {
                // Emit 00:42:00
                emit(Resource.Loading(true))
                val spellsList = dao.getAllItems()
                emit(Resource.Success(
                    data = spellsList.map { it.toItem() }
                ))
                val isDbEmpty = spellsList.isEmpty()
                if(!isDbEmpty){
                    emit(Resource.Loading(false))
                    return@flow
                }
                val remoteSpellsList = try {
                    val response = api.getAllItems().itemsList.map { itemDto -> itemDto.toItem()
                    }
                    response
                }catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error("Não foi possível carregar as Magias"))
                    null
                }catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error("Não foi possível carregar as Magias"))
                    null
                }

                remoteSpellsList?.let { spell ->
                    emit(Resource.Loading(false))
                    dao.clearItemsList()
                    dao.insertItem(
                        spell.map { it.toItemEntity() }
                    )
                }
                emit(Resource.Success(remoteSpellsList))
            }
    }

    override suspend fun getItemByIndex(index: String): Flow<Resource<Item>> =
        withContext(Dispatchers.IO) {
            return@withContext flow {
                // Emit 00:42:00
                emit(Resource.Loading(true))
                val spellsList = dao.getItemByIndex(index)
                emit(Resource.Success(
                    data = spellsList.toItem()
                ))
            }
    }
}