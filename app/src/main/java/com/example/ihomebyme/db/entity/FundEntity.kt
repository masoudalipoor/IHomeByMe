package com.example.ihomebyme.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "funds")
data class FundEntity(var fundName: String, var fundPay: Long) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}