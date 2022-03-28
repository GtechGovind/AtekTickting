package com.gtech.atektickting.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "station")
data class Station(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val station_name: String,
    val station_name_marathi: String,
    val station_code: String
)
