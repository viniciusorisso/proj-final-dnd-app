package com.ficha.dd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Spell(
    val index : String,
    val name : String,
    val url : String
): Parcelable
