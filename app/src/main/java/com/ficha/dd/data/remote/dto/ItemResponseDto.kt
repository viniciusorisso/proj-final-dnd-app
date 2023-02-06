package com.ficha.dd.data.remote.dto

import com.ficha.dd.data.remote.dto.item_response.*
import com.squareup.moshi.Json

data class ItemResponseDto (
    @Json(name = "index")
    val itemIndex: String,
    val name: String,
    val url: String,
    val desc: List<String>?,
    val equipment_category: EquipmentCategoryDto?,
    val weapon_category: String?,
    val weapon_range: String?,
    val range: ItemRangeDto?,
    val damage: ItemDamageDto?,
    val two_handed_damage: TwoHandedDamageItemDto?,
    val properties: List<ItemPropertiesDto>?,
    val cost: ItemCostDto,
    val weight: Float?,
    val armor_category: String?,
    val armor_class: Any?,
    val str_minimum: Int?,
    val stealth_disadvantage: Boolean?,
    val gear_category: ItemGearCategoryDto?,
    val contents: List<ItemContentDto>?,
)