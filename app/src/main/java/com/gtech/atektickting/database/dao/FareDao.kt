package com.gtech.atektickting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gtech.atektickting.database.entity.Fare

@Dao
interface FareDao {

    @Insert
    suspend fun insert(fare: Fare)

    @Update
    suspend fun update(fare: Fare)

    @Query("SELECT fare FROM fare WHERE source = :source_id AND destination = :destination_id AND fare_table_id = :fare_table_id")
    suspend fun getFare(source_id: Int, destination_id: Int, fare_table_id: Int): Double

}