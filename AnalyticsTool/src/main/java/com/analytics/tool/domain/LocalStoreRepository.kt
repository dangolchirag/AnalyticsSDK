package com.analytics.tool.domain

import com.analytics.tool.domain.data.Event
import com.analytics.tool.domain.data.Session
import kotlinx.coroutines.flow.Flow

interface LocalStoreRepository {

    suspend fun insertSession(session: Session)
    suspend fun updateSession(sessionId:String, endTime:Long)
    suspend fun insertEvent(event: Event)

    suspend fun getSessions(): List<Session>
    suspend fun getEvents(): List<Event>

}