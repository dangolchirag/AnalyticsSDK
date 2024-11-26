package com.analytics.tool

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.analytics.tool.AnalyticsSDK


class AnalyticsLifecycleCallbacks: Application.ActivityLifecycleCallbacks {


    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {


    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        AnalyticsSDK.cancel()
    }


}