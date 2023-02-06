package com.ficha.dd.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ItemCost (
    val quantity: Int?,
    val unit: String?,
) : Parcelable
