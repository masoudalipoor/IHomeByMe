package com.example.ihomebyme.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ihomebyme.db.entity.FundEntity


@Dao
interface FundDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFund(funds: FundEntity)

    @Query(QueryUtils.QUERY_GET_ALL_FUND)
    fun getAllFunds(): LiveData<List<FundEntity>>
}