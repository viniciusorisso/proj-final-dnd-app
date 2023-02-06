package com.ficha.dd.data.repository

import com.ficha.dd.data.mapper.toSpell
import com.ficha.dd.data.mapper.toSpellEntity
import com.ficha.dd.data.remote.DndApi
import com.ficha.dd.data.room.DndDatabase
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.domain.repository.SpellRepository
import com.ficha.dd.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

class SpellRepositoryImpl(
    val api: DndApi,
    db: DndDatabase
): SpellRepository {
    private val dao = db.SpellDAO()
    override suspend fun getSpellsList(): Flow<Resource<List<Spell>>> =
        withContext(Dispatchers.IO) {
            return@withContext flow {
                // Emit 00:42:00
                emit(Resource.Loading(true))
                val spellsList = dao.getAllSpells()
                emit(Resource.Success(
                    data = spellsList.map { it.toSpell() }
                ))
                val isDbEmpty = spellsList.isEmpty()
                if(!isDbEmpty){
                    emit(Resource.Loading(false))
                    return@flow
                }
                val remoteSpellsList = try {
                    val response = api.getAllSpells().spellsList.map { spellDto -> spellDto.toSpell()
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
                    dao.clearSpellsList()
                    dao.insertSpell(
                        spell.map { it.toSpellEntity() }
                    )
                }
                emit(Resource.Success(remoteSpellsList))
            }
    }

    override suspend fun getSpellByIndex(index: String): Flow<Resource<Spell>> =
        withContext(Dispatchers.IO) {
            return@withContext flow  {
                // Emit 00:42:00
                emit(Resource.Loading(true))
                val remoteSpell = try {
                    val response = api.getSpellByIndex(index).toSpell()

                    response
                }catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error("Não foi possível carregar a Magia"))
                    null
                }catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error("Não foi possível carregar a Magia"))
                    null
                }
                emit(Resource.Success(
                    data = remoteSpell
                ))
            }
    }
}