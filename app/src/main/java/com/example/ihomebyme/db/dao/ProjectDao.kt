package com.example.ihomebyme.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.ihomebyme.db.entity.ProjectEntity

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(projectEntity: ProjectEntity)

    @Query(QueryUtils.QUERY_SELECT_ALL_PROJECTS)
    fun getAllProjects(): LiveData<List<ProjectEntity>>

    @Delete
    suspend fun deleteAll(projects: List<ProjectEntity>)

//    @Query("Delete From projects Where id in (:ids)")
//    fun deleteItemProject(ids: List<Long>)
}