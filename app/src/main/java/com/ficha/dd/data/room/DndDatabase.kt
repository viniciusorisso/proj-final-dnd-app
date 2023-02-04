package com.ficha.dd.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ficha.dd.data.dao.CharacterSheetDAO
import com.ficha.dd.data.dao.ItemDAO
import com.ficha.dd.data.dao.SpellDAO
import com.ficha.dd.data.local.CharacterSheetEntity
import com.ficha.dd.data.local.ItemEntity
import com.ficha.dd.data.local.ObjectTypeConverter
import com.ficha.dd.data.local.SpellEntity

@Database(
    entities = [SpellEntity::class, ItemEntity::class, CharacterSheetEntity::class],
    version = 1
)
@TypeConverters(ObjectTypeConverter::class)
abstract class DndDatabase(): RoomDatabase() {
    abstract fun SpellDAO(): SpellDAO
    abstract fun ItemDAO(): ItemDAO

    abstract fun CharacterSheetDAO(): CharacterSheetDAO
}