package com.gtech.atektickting.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipment")
data class Equipment(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val equipment_id: String,
    val eq_type_id: Int,
    val end_date: String?,
    val status: Boolean,
    val station_id: String
)
