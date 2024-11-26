package com.analytics.tool.domain.mapper

import com.analytics.tool.core.db.entity.EventEntity
import com.analytics.tool.core.db.entity.SessionEntity
import com.analytics.tool.domain.data.Event
import com.analytics.tool.domain.data.Session

fun SessionEntity.toSession(): Session {
    return Session(
        sessionId = sessionId,
        startTime = startTime,
        endTime = endTime,
        deviceId = deviceId,
        appVersion = appVersion
    )
}

fun Session.toSessionEntity(): SessionEntity {
    return SessionEntity(
        sessionId = sessionId,
        startTime = startTime,
        endTime = endTime,
        deviceId = deviceId,
        appVersion = appVersion
    )
}

fun EventEntity.toEvent(): Event {
    return Event(
        eventId = eventId,
        sessionId = sessionId,
        eventName = eventName,
        timestamp = timestamp,
        properties = properties
    )
}

fun Event.toEventEntity(): EventEntity {
    return EventEntity(
        eventId = eventId,
        sessionId = sessionId,
        eventName = eventName,
        timestamp = timestamp,
        properties = properties
    )
}