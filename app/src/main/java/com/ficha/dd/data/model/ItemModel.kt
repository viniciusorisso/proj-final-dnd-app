package com.ficha.dd.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName="item")
class ItemModel {
    @PrimaryKey(autoGenerate = false)
    var index : String = ""

    @ColumnInfo(name="name")
    var name : String = ""

    @ColumnInfo(name="url")
    var url : String = ""
}