package com.ficha.dd.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ficha.dd.data.model.ItemModel

@Dao
interface ItemDAO {

    @Insert
    fun insert(p: ItemModel)

    @Insert
    fun update(p: ItemModel)

    @Delete
    fun delete(p: ItemModel)

}