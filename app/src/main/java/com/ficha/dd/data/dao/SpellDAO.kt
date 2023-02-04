package com.ficha.dd.data.dao

import androidx.room.*
import com.ficha.dd.data.local.SpellEntity

@Dao
interface SpellDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpell(spellsList: List<SpellEntity>)
    @Query("DELETE FROM spell")
    suspend fun clearSpellsList()

    @Query("SELECT * FROM spell WHERE spellIndex = :index")
    fun getSpellByIndex(index: String): SpellEntity
    @Query("SELECT * FROM spell")
    suspend fun getAllSpells(): List<SpellEntity>
}