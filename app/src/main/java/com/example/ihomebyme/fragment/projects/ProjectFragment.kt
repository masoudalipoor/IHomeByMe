package com.example.ihomebyme.fragment.projects

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ihomebyme.R
import com.example.ihomebyme.db.HomeByMeDatabase
import com.example.ihomebyme.db.entity.ProjectEntity
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class ProjectFragment : Fragment(R.layout.fragment_project) {

    val db = HomeByMeDatabase.getDatabase()
    val dao = db.projectDao()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNewProjectButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                launch {
                    val name = projectNameEditText.text.toString()
                    dao.insert(ProjectEntity(name))
                }
            }

        }
    }
}