package com.ficha.dd.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ficha.dd.data.local.CharacterSheetEntity
import com.ficha.dd.domain.model.Spell

@Dao
interface CharacterSheetDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertCharacterSheet(character: CharacterSheetEntity)

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun pushNewCharacterSpell(characterId: Int, spell: Spell)

    @Query("DELETE FROM character WHERE id = :id")
    fun deleteCharacterSheetById(id: Int)

    @Query("SELECT * FROM character WHERE id = :id")
    fun getCharacterById(id: Int): CharacterSheetEntity

    @Query("SELECT * FROM character")
    fun getAllCharactersSheet(): List<CharacterSheetEntity>
}