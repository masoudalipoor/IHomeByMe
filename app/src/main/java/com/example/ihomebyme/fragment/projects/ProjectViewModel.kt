package com.example.ihomebyme.fragment.projects

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.ProjectEntity
import kotlinx.coroutines.launch

//@HiltViewModel
class ProjectViewModel @ViewModelInject constructor(
    private var projectDao: ProjectDao
) : ViewModel() {

    init {
        Log.e("ProjectViewModel >>>> ", " init ")
    }

    val getProjects: LiveData<List<ProjectEntity>> = projectDao.getAllProjects()

    fun insertProject(projectEntity: ProjectEntity) = viewModelScope.launch {
        projectDao.insert(projectEntity)
    }

    fun delete(projects: List<ProjectEntity>) = viewModelScope.launch {
        projectDao.deleteAll(projects)
    }

}