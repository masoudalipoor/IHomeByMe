package com.example.ihomebyme.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ihomebyme.db.entity.ProjectEntity

@Database(entities = [ProjectEntity::class], version = 1, exportSchema = false)
abstract class HomeByMeDatabase : RoomDatabase() {

    companion object {
        fun getDatabase(context: Context) {
            Room.databaseBuilder(
                context,
                HomeByMeDatabase::class.java,
                "homebyme"
            )
                .build()
        }
    }
}