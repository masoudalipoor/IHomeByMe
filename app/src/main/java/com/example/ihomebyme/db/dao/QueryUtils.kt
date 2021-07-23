package com.example.ihomebyme.db.dao

object QueryUtils {
    /**
     * projects
     */
    const val TABLE_PROJECTS = "projects"
    const val QUERY_SELECT_ALL_PROJECTS = "SELECT * FROM $TABLE_PROJECTS"
    const val QUERY_DELETE_ALL_PROJECTS = "DELETE * FROM $TABLE_PROJECTS Where id in (:ids)"

    /**
     * funder
     */


}