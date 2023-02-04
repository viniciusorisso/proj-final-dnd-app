package com.ficha.dd.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ficha.dd.data.model.SpellModel

@Dao
interface SpellDAO {

    @Insert
    fun insert(p: SpellModel)

    @Insert
    fun update(p: SpellModel)

    @Delete
    fun delete(p: SpellModel)

    @Query("SELECT * FROM spell WHERE spellIndex = :index")
    fun getSpellByIndex(index: String): SpellModel
}