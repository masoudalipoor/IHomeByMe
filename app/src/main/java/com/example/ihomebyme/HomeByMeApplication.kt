package com.example.ihomebyme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HomeByMeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}