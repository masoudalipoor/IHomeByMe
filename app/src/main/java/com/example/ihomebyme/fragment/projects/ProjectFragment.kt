package com.example.ihomebyme.fragment.projects

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ihomebyme.R
import com.example.ihomebyme.adapter.ProjectAdapter
import com.example.ihomebyme.db.entity.ProjectEntity
import com.example.ihomebyme.fragment.getViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_project.*


@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project) {

    //    private val viewModel: ProjectViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = getViewModel<ProjectViewModel>()
        
        with(viewModel) {
            addNewProjectButton.setOnClickListener {
                projectNameEditText.apply {
                    insertProject(ProjectEntity(text.toString()))
                }
            }

            getProjects.observe(viewLifecycleOwner) { projects ->
                initRecyclerView(listOfProjects = projects)

                deleteAllButton.setOnClickListener {
                    delete(projects)
                }
            }
        }

    }

    fun initRecyclerView(listOfProjects: List<ProjectEntity>) {
        projectsRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ProjectAdapter(context, listOfProjects)
        }
    }
}