package com.analytics.tool

import android.app.Application
import com.analytics.tool.core.db.AnalyticsDB
import com.analytics.tool.data.local.LocalStoreRepositoryImpl
import com.analytics.tool.domain.use_case.InsertEventUseCase
import com.analytics.tool.domain.use_case.InsertSessionUseCase
import com.analytics.tool.domain.use_case.UpdateSessionUseCase

class AnalyticsSDK private constructor(private val analyticsClient: AnalyticsClient) {

    companion object {
        private var instance: AnalyticsSDK? = null

        fun initialize(application: Application): AnalyticsSDK {
            application.registerActivityLifecycleCallbacks(AnalyticsLifecycleCallbacks())
            return instance ?: synchronized(this) {
                val db = AnalyticsDB.getDatabase(application.applicationContext)
                val repo = LocalStoreRepositoryImpl(db)
                AnalyticsSDK(
                    AnalyticsClient(
                        insertSessionUseCase = InsertSessionUseCase(repo),
                        insertEventUseCase = InsertEventUseCase(repo),
                        updateSessionUseCase = UpdateSessionUseCase(repo)
                    )
                ).also { instance = it }
            }
        }


        fun startSession() {
            checkInstance()
            instance?.analyticsClient?.startSession()
        }

        fun stopSession() {
            checkInstance()
            instance?.analyticsClient?.endSession()
        }

        fun trackEvent(eventName: String, properties: Map<String, Any>?) {
            checkInstance()
            instance?.analyticsClient?.trackEvent(eventName = eventName, properties = properties)
        }

        fun cancel() {
            checkInstance()
            instance?.analyticsClient?.cancel()
        }

        private fun checkInstance() {
            if (instance == null) {
                throw AnalyticsSdkNotInitializedException("Analytics SDK not initialized. Call initialize() first.")
            }
        }
    }


}