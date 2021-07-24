package com.example.ihomebyme.fragment.fund

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ihomebyme.db.dao.FundDao
import com.example.ihomebyme.db.entity.FundEntity
import kotlinx.coroutines.launch

class FundViewModel @ViewModelInject constructor(
    private val funDao: FundDao
) : ViewModel() {

    val allFund: LiveData<List<FundEntity>> = funDao.getAllFunds()

    fun insertFund(fundEntity: FundEntity) = viewModelScope.launch {
        funDao.insertFund(fundEntity)
    }

}