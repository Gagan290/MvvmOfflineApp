package com.mvvmofflineapp.application

import android.app.Application

class BaseApplication : Application() {//, Application.ActivityLifecycleCallbacks {

    companion object {
        private lateinit var instance: BaseApplication
        fun getInstance(): BaseApplication = instance
    }
}