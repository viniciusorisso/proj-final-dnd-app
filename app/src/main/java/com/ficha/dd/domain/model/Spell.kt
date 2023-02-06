package com.ficha.dd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Spell(
    val index : String,
    val name : String,
    val url : String,
    val level: Int?,
    val desc: List<String>?,
    val attack_type: String?,
    val duration: String?,
    val range: String?,
    val casting_time: String?
): Parcelable
