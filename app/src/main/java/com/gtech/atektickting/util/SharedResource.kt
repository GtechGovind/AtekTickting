package com.gtech.atektickting.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedResource(context: Context) {

    private var resource: SharedPreferences = context.getSharedPreferences(
        "ATEK_STATIC_DATA", MODE_PRIVATE
    )

    fun saveData(key: Key, data: Any) {
        when (data) {
            is Int -> resource.edit().putInt(key.toString(), data).apply()
            is String -> resource.edit().putString(key.toString(), data).apply()
            is Boolean -> resource.edit().putBoolean(key.toString(), data).apply()
            is Float -> resource.edit().putFloat(key.toString(), data).apply()
            is Long -> resource.edit().putLong(key.toString(), data).apply()
        }
    }

    fun getStringDataData(key: Key) {
        resource.getString(key.toString(), "")
    }

    fun getIntDataData(key: Key): Int {
        return resource.getInt(key.toString(), 0)
    }

    fun getBoolDataData(key: Key): Boolean {
        return resource.getBoolean(key.toString(), false)
    }

    fun getFloatDataData(key: String): Float {
        return resource.getFloat(key.toString(), 0F)
    }

    fun getLongDataData(key: String): Long {
        return resource.getLong(key.toString(), 0L)
    }

}

enum class Key {
    IS_CONFIGURED,
    IS_LOGIN
}



