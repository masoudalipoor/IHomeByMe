package com.example.ihomebyme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ihomebyme.R
import com.example.ihomebyme.db.dao.ProjectDao
import com.example.ihomebyme.db.entity.ProjectEntity
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.synthetic.main.projects_list.view.*
import javax.inject.Inject

@FragmentScoped
class ProjectAdapter @Inject constructor() :
    RecyclerView.Adapter<ProjectAdapter.ViewHolderProject>() {

    var context: Context? = null
    var listOfProjects: List<ProjectEntity>? = null

    fun ownerContext(@ActivityContext context: Context) {
        this.context = context
    }

    fun initListOfProjects(listOfProjects: List<ProjectEntity>) {
        this.listOfProjects = listOfProjects
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProject =
        ViewHolderProject(
            LayoutInflater.from(context).inflate(R.layout.projects_list, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolderProject, position: Int) {
//        val project: ProjectEntity? = null
        val project: ProjectEntity = listOfProjects!![position]

        with(holder) {
            nameProject.text = project.projectName
        }

//        project.let { listOfProjects?.get(position) }
//            .also {
//                holder.nameProject.text = it?.projectName
//            }
    }


    override fun getItemCount(): Int = listOfProjects?.size!!

    inner class ViewHolderProject(view: View) : RecyclerView.ViewHolder(view) {

        val nameProject = view.showProjectNameTxtView
        val removeItem = view.removeItemImageView
    }
}