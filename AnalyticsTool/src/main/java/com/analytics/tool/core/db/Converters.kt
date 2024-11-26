package com.analytics.tool.core.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromString(value: String?): Map<String, Any>? {
        val type = object : TypeToken<Map<String, Any>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromMap(map: Map<String, Any>?): String? {
        return Gson().toJson(map)
    }
}