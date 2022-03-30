package com.gtech.atektickting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gtech.atektickting.database.entity.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM user WHERE user_name = :user_name")
    suspend fun getUser(user_name: String): User?

}