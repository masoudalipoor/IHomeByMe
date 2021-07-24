package com.example.ihomebyme.fragment.projects

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.ProjectEntity
import kotlinx.coroutines.launch

//@HiltViewModel
class ProjectViewModel @ViewModelInject constructor(
    private var projectDao: ProjectDao
) : ViewModel() {

//    val getProjects: LiveData<List<ProjectEntity>> = liveData {
//        val s = projectDao.getAllProjects()
//        emit(s)
//    }

    val getProjects: LiveData<List<ProjectEntity>> = projectDao.getAllProjects()

    fun insertProject(projectEntity: ProjectEntity) = viewModelScope.launch {
        projectDao.insert(projectEntity)
    }

    fun delete(projects: List<ProjectEntity>) = viewModelScope.launch {
        projectDao.deleteAll(projects)
    }

}