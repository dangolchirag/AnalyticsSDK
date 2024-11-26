package com.analytics.tool.domain.data
data class Event(
    val eventId: String,
    val sessionId: String,
    val eventName: String,
    val timestamp: Long,
    val properties: Map<String, Any>
)