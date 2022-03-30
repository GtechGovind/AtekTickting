package com.gtech.atektickting.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gtech.atektickting.database.entity.Product

@Dao
interface ProductDao {

    @Insert
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Query("SELECT * FROM product")
    suspend fun getProducts(): List<Product>

    @Query("SELECT * FROM product WHERE pass_id = :pass_id")
    suspend fun getProduct(pass_id: Int): Product

}