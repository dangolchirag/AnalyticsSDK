package com.analytics.tool.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SessionEntity(
    @PrimaryKey(autoGenerate = false)
    val sessionId: String,
    val startTime: Long,
    val endTime: Long,
    val deviceId: String,
    val appVersion: String
)
