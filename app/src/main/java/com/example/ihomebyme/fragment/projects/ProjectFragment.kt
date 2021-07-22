package com.example.ihomebyme.fragment.projects

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ihomebyme.R
import com.example.ihomebyme.db.entity.ProjectEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_project.*


@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project) {

    private val viewModel: ProjectViewModel  by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNewProjectButton.setOnClickListener {
            val name = projectNameEditText.text.toString()
            viewModel.insertProject(ProjectEntity(name))
        }
    }


}