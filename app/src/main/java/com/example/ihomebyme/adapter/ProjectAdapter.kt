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
import kotlinx.android.synthetic.main.projects_list.view.*

class ProjectAdapter constructor(
    private var context: Context?,
    private var listOfProjects: List<ProjectEntity>?
) : RecyclerView.Adapter<ProjectAdapter.ViewHolderProject>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProject =
        ViewHolderProject(
            LayoutInflater.from(context).inflate(R.layout.projects_list, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolderProject, position: Int) {
//        val project: ProjectEntity? = null
        val project: ProjectEntity = listOfProjects!![position]

        with(holder) {
            nameProject.text =  project.projectName
        }

//        project.let { listOfProjects?.get(position) }
//            .also {
//                holder.nameProject.text = it?.projectName
//            }
    }


    override fun getItemCount(): Int = listOfProjects?.size!!

    class ViewHolderProject(view: View) : RecyclerView.ViewHolder(view) {

        val nameProject = view.showProjectNameTxtView
        val removeItem = view.removeItemImageView
    }
}