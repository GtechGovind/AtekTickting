package com.gtech.atektickting.model.configure

data class Fare(
    val destination: String,
    val fare: String,
    val fare_table_id: String,
    val fare_version: Any,
    val id: String,
    val source: String
)