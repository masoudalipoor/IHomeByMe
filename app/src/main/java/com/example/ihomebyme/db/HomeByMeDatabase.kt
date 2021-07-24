package com.example.ihomebyme.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihomebyme.db.dao.FundDao
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.FundEntity
import com.example.ihomebyme.db.entity.ProjectEntity

@Database(
    entities = [ProjectEntity::class, FundEntity::class],
    version = 1, exportSchema = false
)
abstract class HomeByMeDatabase : RoomDatabase() {

    abstract fun projectDao(): ProjectDao
    abstract fun fundDao(): FundDao
}