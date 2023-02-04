package com.ficha.dd.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ficha.dd.data.dao.ItemDAO
import com.ficha.dd.data.dao.SpellDAO
import com.ficha.dd.data.model.ItemModel
import com.ficha.dd.data.model.SpellModel

@Database(entities = [SpellModel::class, ItemModel::class], version = 1)
abstract class AppDatabase(): RoomDatabase() {
    abstract fun SpellDAO(): SpellDAO
    abstract fun ItemDAO(): ItemDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "mydatabase.db"
            ).build()
    }

}