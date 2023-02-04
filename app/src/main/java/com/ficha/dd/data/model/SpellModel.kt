package com.ficha.dd.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName="spell")
class SpellModel {
    @PrimaryKey(autoGenerate = false)
    @field:Json(name="index")
    var spellIndex : String = ""

    @ColumnInfo(name="name")
    var name : String = ""

    @ColumnInfo(name="url")
var url : String = ""
}