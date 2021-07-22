package com.example.ihomebyme.fragment.projects

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.ProjectEntity
import kotlinx.coroutines.launch

//@HiltViewModel
class ProjectViewModel @ViewModelInject constructor(
    var projectDao: ProjectDao
) : ViewModel() {


    fun insertProject(projectEntity: ProjectEntity) = viewModelScope.launch {
        projectDao.insert(projectEntity)
    }
}