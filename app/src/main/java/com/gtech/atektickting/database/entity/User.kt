package com.gtech.atektickting.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val user_id: String,
    val user_name: String,
    val email: String,
    val phone: String,
    val surname: String,
    val password: String,
    val operator_id: String
)
