package com.example.ihomebyme

import android.app.Application
import android.content.Context
import com.example.ihomebyme.db.HomeByMeDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HomeByMeApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext

    }
}