package com.ficha.dd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class Item(
    val index: String,
    val name: String,
    val url: String,
    val desc: List<String>?,
    val itemCost: ItemCost?,
) : Parcelable
