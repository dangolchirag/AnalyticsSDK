package com.analytics.sdk

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //AnalyticsSDK.initialize(this)
    }
}