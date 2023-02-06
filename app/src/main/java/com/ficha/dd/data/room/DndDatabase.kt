package com.ficha.dd.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ficha.dd.data.dao.ItemDAO
import com.ficha.dd.data.dao.SpellDAO
import com.ficha.dd.data.local.ItemEntity
import com.ficha.dd.data.local.SpellEntity

@Database(
    entities = [SpellEntity::class, ItemEntity::class],
    version = 1
)
abstract class DndDatabase(): RoomDatabase() {
    abstract fun SpellDAO(): SpellDAO
    abstract fun ItemDAO(): ItemDAO
}