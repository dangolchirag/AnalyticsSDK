package com.analytics.tool

import android.util.Log
import com.analytics.tool.domain.data.Event
import com.analytics.tool.domain.use_case.InsertEventUseCase
import com.analytics.tool.domain.use_case.InsertSessionUseCase
import com.analytics.tool.domain.use_case.UpdateSessionUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.UUID

class AnalyticsClient(
    private val insertEventUseCase: InsertEventUseCase,
    private val updateSessionUseCase: UpdateSessionUseCase,
    private val insertSessionUseCase: InsertSessionUseCase
) {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    fun startSession() {
        scope.launch {
            val session = SessionManager.startSession()
            try {
                insertSessionUseCase(session)
            } catch (ex: Exception) {
                Log.e(TAG, "startSession: ", ex)
            }
        }
    }

    fun endSession() {
        scope.launch {
            try {
                val sessionId = SessionManager.stopSession()
                sessionId?.let {
                    updateSessionUseCase(it, System.currentTimeMillis())
                }
            } catch (ex: Exception) {
                Log.e(TAG, "endSession: ", ex)
            }
        }
    }

    fun trackEvent(eventName: String, properties: Map<String, Any>?) {
        SessionManager.getSessionId()?.let { sessionId ->
            val event = Event(
                UUID.randomUUID().toString(),
                sessionId,
                eventName,
                System.currentTimeMillis(),
                properties ?: emptyMap()
            )
            scope.launch {
                try {
                    insertEventUseCase(event)
                } catch (ex: Exception) {
                    Log.e(TAG, "trackEvent: ", ex)
                }
            }
        }
    }

    fun cancel() {
        scope.cancel()
    }

    companion object {
        private const val TAG = "AnalyticsClient"
    }

}