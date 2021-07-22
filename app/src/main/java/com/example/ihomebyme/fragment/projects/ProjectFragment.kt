package com.example.ihomebyme.fragment.projects

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ihomebyme.R
import com.example.ihomebyme.db.HomeByMeDatabase
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.ProjectEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project) {

//    private val viewModel: ProjectViewModel  by viewMode

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNewProjectButton.setOnClickListener {


        }

    }
}