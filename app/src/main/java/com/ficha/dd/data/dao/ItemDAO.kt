package com.ficha.dd.data.dao

import androidx.room.*
import com.ficha.dd.data.local.ItemEntity

@Dao
interface ItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(itemsList: List<ItemEntity>)

    @Query("DELETE FROM item")
    suspend fun clearItemsList()

    @Query("SELECT * FROM item WHERE itemIndex = :index")
    fun getItemByIndex(index: String): ItemEntity

    @Query("SELECT * FROM item")
    suspend fun getAllItems(): List<ItemEntity>

}