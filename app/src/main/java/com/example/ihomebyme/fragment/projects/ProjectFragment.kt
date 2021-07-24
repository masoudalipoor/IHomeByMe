package com.example.ihomebyme.fragment.projects

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ihomebyme.R
import com.example.ihomebyme.adapter.ProjectAdapter
import com.example.ihomebyme.db.entity.ProjectEntity
import com.example.ihomebyme.fragment.getViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_project.*


@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = getViewModel<ProjectViewModel>()

        with(viewModel) {

            addNewProjectButton.setOnClickListener {
                projectNameEditText.apply {
                    this@with.insertProject(ProjectEntity(this@apply.text.toString()))
                }
            }

            this@with.getProjects.observe(viewLifecycleOwner) { projects ->
                initRecyclerView(listOfProjects = projects)
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