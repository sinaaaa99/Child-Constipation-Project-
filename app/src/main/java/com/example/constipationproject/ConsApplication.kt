package com.example.constipationproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ConsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}