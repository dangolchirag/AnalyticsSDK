package com.analytics.tool

import com.analytics.tool.domain.data.Session

object SessionManager {
    private var currentSessionId: String? = null

    fun startSession(): Session {
        if (currentSessionId != null) {
            throw IllegalStateException("Session already started")
        }
        currentSessionId = generateSessionId()
        val session = Session(
            currentSessionId!!, System.currentTimeMillis(), 0L,
            // Add device ID and app version
            "device_id", "app_version"
        )
        return session
    }

    fun stopSession(): String? {
        val sessionId = currentSessionId
        currentSessionId = null
        return sessionId
    }

    fun getSessionId(): String? = currentSessionId

    private fun generateSessionId(): String = "session-${System.currentTimeMillis()}"
}