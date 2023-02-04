package com.ficha.dd.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.ficha.dd.data.local.ItemEntity

@Dao
interface ItemDAO {

    @Insert
    fun insert(p: ItemEntity)

    @Insert
    fun update(p: ItemEntity)

    @Delete
    fun delete(p: ItemEntity)

}