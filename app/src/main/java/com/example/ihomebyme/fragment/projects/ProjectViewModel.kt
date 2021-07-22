package com.example.ihomebyme.fragment.projects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihomebyme.db.entity.ProjectEntity
import kotlinx.coroutines.launch

//@HiltViewModel
class ProjectViewModel : ViewModel() {

//    @Inject
//    lateinit var projectDao: ProjectDao

    fun insertProject(projectEntity: ProjectEntity) = viewModelScope.launch {
//        projectDao.insert(projectEntity)
    }
}