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
    const val TABLE_FUND = "funds"
    const val QUERY_GET_ALL_FUND = "SELECT * FROM $TABLE_FUND"
    const val QUERY_UPDATE_FUND = "Update $TABLE_FUND set fundPay=:extraMony Where fundName=:name"


}