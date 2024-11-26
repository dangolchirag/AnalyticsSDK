package com.analytics.tool.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.analytics.tool.core.db.Converters

@Entity
data class EventEntity(
    @PrimaryKey(autoGenerate = false)
    val eventId: String,
    val sessionId: String,
    val eventName: String,
    val timestamp: Long,
    @TypeConverters(Converters::class)
    val properties: Map<String, Any>
)