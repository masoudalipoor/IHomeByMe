package com.example.ihomebyme.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ihomebyme.db.entity.FundEntity
import io.reactivex.rxjava3.core.Completable


@Dao
interface FundDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFund(funds: FundEntity) 

    @Query(QueryUtils.QUERY_GET_ALL_FUND)
    fun getAllFunds(): LiveData<List<FundEntity>> 

    @Query(QueryUtils.QUERY_UPDATE_FUND)
    suspend fun insertNewDataToFundPerson(extraMony: Long, name: String)
}