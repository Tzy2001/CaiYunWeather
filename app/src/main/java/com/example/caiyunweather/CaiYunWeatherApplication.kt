package com.example.caiyunweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class CaiYunWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN="vII6ml0pECSG3mfS"

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}