package com.gtech.atektickting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gtech.atektickting.database.entity.Equipment

@Dao
interface EquipmentDao {

    @Insert
    suspend fun insert(equipment: Equipment)

    @Update
    suspend fun update(equipment: Equipment)

    @Query("SELECT * FROM equipment")
    suspend fun getEquipment(): Equipment

}