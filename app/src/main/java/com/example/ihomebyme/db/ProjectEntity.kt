package com.example.ihomebyme.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity(var projectName: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
