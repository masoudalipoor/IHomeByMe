package com.example.ihomebyme.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.ProjectEntity

@Database(entities = [ProjectEntity::class], version = 1, exportSchema = false)
abstract class HomeByMeDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: HomeByMeDatabase? = null
        fun getDatabase(context: Context): HomeByMeDatabase {
            INSTANCE = Room.databaseBuilder(
                context,
                HomeByMeDatabase::class.java,
                "homebyme"
            )
                .build()

            return INSTANCE!!
        }
    }

    abstract fun projectDao(): ProjectDao
}