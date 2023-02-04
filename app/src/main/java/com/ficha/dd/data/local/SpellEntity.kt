package com.ficha.dd.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "spell")
data class SpellEntity (
    @PrimaryKey(autoGenerate = false)
    @field:Json(name="index")
    var spellIndex : String,
    var name : String,
    var url : String
)