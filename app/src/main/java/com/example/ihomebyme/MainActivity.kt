package com.example.ihomebyme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ihomebyme.db.HomeByMeDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HomeByMeDatabase.getDatabase(this)
    }
}