package com.analytics.tool.domain.data

data class Session(
    val sessionId: String,
    val startTime: Long,
    var endTime: Long,
    val deviceId: String,
    val appVersion: String
)
