package com.gtech.atektickting.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gtech.atektickting.model.transaction.Request

@Entity(tableName = "sync_transaction")
data class SyncTransaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val request: Request,
    val is_synced: Boolean,
    val product: Int,
    val op_type_id: Int,
    val number: String,
    val otp: Int,
    val media: Int,
    val type: Int,
    val unit: Int,
    val fare: Double,
    val shift_id: Int,
    val pay_type_id: Int
)
