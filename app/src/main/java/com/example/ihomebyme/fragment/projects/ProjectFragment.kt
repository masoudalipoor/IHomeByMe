package com.example.ihomebyme.fragment.projects

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ihomebyme.R
import com.example.ihomebyme.adapter.ProjectAdapter
import com.example.ihomebyme.db.entity.ProjectEntity
import com.example.ihomebyme.fragment.getViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.android.synthetic.main.fragment_project.*
import javax.inject.Inject


@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project) {

    @Inject
    lateinit var projectAdapter: ProjectAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = getViewModel<ProjectViewModel>()

        with(viewModel) {

            addNewProjectButton.setOnClickListener {
                projectNameEditText.let {
                    this@with.insertProject(ProjectEntity(it.text.toString()))
                }
            }

//            getProjects.observe(viewLifecycleOwner, { projects ->
//                initRecyclerView(listOfProjects = projects)
//            })
            this@with.getProjects.observe(viewLifecycleOwner) { projects ->
                initRecyclerView(listOfProjects = projects)
            }

        }
    }

     fun initRecyclerView(listOfProjects: List<ProjectEntity>) {
        projectsRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = projectAdapter
            projectAdapter.ownerContext(context)
            projectAdapter.initListOfProjects(listOfProjects)
        }
    }
}