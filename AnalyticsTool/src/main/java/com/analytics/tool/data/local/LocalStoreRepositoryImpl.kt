package com.analytics.tool.data.local

import com.analytics.tool.core.db.AnalyticsDB
import com.analytics.tool.core.db.dao.EventDao
import com.analytics.tool.core.db.dao.SessionDao
import com.analytics.tool.domain.LocalStoreRepository
import com.analytics.tool.domain.data.Event
import com.analytics.tool.domain.data.Session
import com.analytics.tool.domain.mapper.toEvent
import com.analytics.tool.domain.mapper.toEventEntity
import com.analytics.tool.domain.mapper.toSession
import com.analytics.tool.domain.mapper.toSessionEntity

class LocalStoreRepositoryImpl(db: AnalyticsDB) : LocalStoreRepository {

    private val eventDao: EventDao = db.eventDao
    private val sessionDao: SessionDao = db.sessionDao

    override suspend fun insertSession(session: Session) {
        sessionDao.insertSession(session.toSessionEntity())
    }

    override suspend fun updateSession(sessionId: String, endTime: Long) {
        sessionDao.upsertSession(sessionId = sessionId, endTime = endTime)
    }

    override suspend fun insertEvent(event: Event) {
        eventDao.insertEvent(event.toEventEntity())
    }

    override suspend fun getSessions(): List<Session> {
        return sessionDao.getSessions().map { it.toSession() }
    }

    override suspend fun getEvents(): List<Event> {
        return eventDao.getEvents().map { it.toEvent() }
    }
}