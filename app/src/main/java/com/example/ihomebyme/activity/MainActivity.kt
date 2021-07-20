package com.example.ihomebyme.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ihomebyme.R
import com.example.ihomebyme.db.HomeByMeDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HomeByMeDatabase.getDatabase(this)

    }
}