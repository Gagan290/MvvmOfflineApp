package com.mvvmofflineapp.repository.cache

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.mvvmofflineapp.application.BaseApplication

class SharedPrefsCache {
    private var preferences: SharedPreferences? = null
    private val preferenceName = "MvvmOffline"

    init {
        Log.e("SharedPrefsCache", "init block")
        preferences = BaseApplication.getInstance().getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    }

    companion object {

        fun getString() {
            Log.e("SharedPrefsCache", "getString")
        }
    }
}
