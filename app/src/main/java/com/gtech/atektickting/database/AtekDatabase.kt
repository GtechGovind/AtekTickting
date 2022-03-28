package com.gtech.atektickting.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gtech.atektickting.database.dao.*
import com.gtech.atektickting.database.entity.*

@Database(
    entities = [
        Equipment::class,
        Fare::class,
        Product::class,
        Station::class,
        User::class],
    version = 1
)
abstract class AtekDatabase : RoomDatabase() {

    abstract fun equipmentDao(): EquipmentDao
    abstract fun fareDao(): FareDao
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
    abstract fun stationDao(): StationDao

    companion object {

        @Volatile
        private var instance: AtekDatabase? = null

        fun getInstance(context: Context?): AtekDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context?.applicationContext!!, AtekDatabase::class.java,
                    "ATEK_METRO_DATABASE"
                ).build()

            }
            return instance!!
        }

    }

}