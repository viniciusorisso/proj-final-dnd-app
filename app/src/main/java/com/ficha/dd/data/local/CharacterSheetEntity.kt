package com.ficha.dd.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.util.JsonUtils
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Entity(tableName = "character")
class CharacterSheetEntity (
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name : String,
    var level: Int?,
    var spellsList: List<Spell>?,
    var itemsList: List<Item>?,
)


class ObjectTypeConverter: KoinComponent {

    private val jsonUtils by inject<JsonUtils>()

    @TypeConverter
    fun spellToString(myObj: List<Spell>?): String = jsonUtils.convertObjectToJson(myObj)

    @TypeConverter
    fun stringToSpell(myObjStr: String): List<Spell>? = jsonUtils.convertJsonToObject(myObjStr)

    @TypeConverter
    fun itemToString(myObj: List<Item>?): String = jsonUtils.convertObjectToJson(myObj)

    @TypeConverter
    fun stringToItem(myObjStr: String): List<Item>? = jsonUtils.convertJsonToObject(myObjStr)
}
