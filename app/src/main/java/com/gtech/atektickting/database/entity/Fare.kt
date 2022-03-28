package com.gtech.atektickting.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fare")
data class Fare(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val fare_table_id: Int,
    val source: Int,
    val destination: Int,
    val fare: Double
)
