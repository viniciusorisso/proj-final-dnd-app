package com.ficha.dd.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "item")
data class ItemEntity (
    @PrimaryKey(autoGenerate = false)
    @field:Json(name="index")
    var itemIndex : String,
    var name : String,
    var url : String,
)