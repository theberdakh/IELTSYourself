package com.theberdakh.ieltsyourself.utils

import android.app.Application

class App: Application() {
    companion object{
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}