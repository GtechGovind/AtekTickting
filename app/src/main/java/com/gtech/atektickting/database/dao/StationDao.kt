package com.gtech.atektickting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gtech.atektickting.database.entity.Station

@Dao
interface StationDao {

    @Insert
    suspend fun insert(station: Station)

    @Update
    suspend fun update(station: Station)

    @Query("SELECT * FROM station")
    suspend fun getAllStations(): List<Station>

    @Query("SELECT * FROM station WHERE id = :id")
    suspend fun getStation(id: Int): Station

}