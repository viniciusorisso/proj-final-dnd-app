package com.ficha.dd.util

import com.squareup.moshi.Moshi

class JsonUtils(
    val moshi: Moshi
){
    inline fun <reified T> convertJsonToObject(json: String): T? =
        moshi.adapter(T::class.java).fromJson(json)

    inline fun <reified T> convertObjectToJson(objectData: T): String =
        moshi.adapter(T::class.java).toJson(objectData)
}