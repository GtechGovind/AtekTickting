package com.gtech.atektickting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface SyncTransactionDao {

    @Insert
    suspend fun insert(syncTransactionDao: SyncTransactionDao)

    @Update
    suspend fun update(syncTransactionDao: SyncTransactionDao)

}