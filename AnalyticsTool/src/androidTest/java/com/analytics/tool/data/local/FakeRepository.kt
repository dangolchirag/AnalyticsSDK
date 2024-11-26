package com.analytics.tool.data.local

import com.analytics.tool.domain.LocalStoreRepository
import com.analytics.tool.domain.data.Event
import com.analytics.tool.domain.data.Session
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository: LocalStoreRepository {

    private val sessions = mutableListOf<Session>()
    private val events = mutableListOf<Event>()

    override suspend fun insertSession(session: Session) {
        sessions.add(session)
    }

    override suspend fun updateSession(sessionId: String, endTime: Long) {
        sessions.firstOrNull { it.sessionId == sessionId }?.let { session ->
            session.endTime = endTime
        }
    }

    override suspend fun insertEvent(event: Event) {
        events.add(event)
    }

    override suspend fun  getSessions():List<Session> {
        return sessions
    }

    override suspend fun getEvents(): List<Event> {
        return events
    }
}