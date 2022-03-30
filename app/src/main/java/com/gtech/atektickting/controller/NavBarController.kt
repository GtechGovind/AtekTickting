package com.gtech.atektickting.controller

import android.annotation.SuppressLint
import android.app.Activity
import com.gtech.atektickting.BuildConfig
import com.gtech.atektickting.database.AtekDatabase
import com.gtech.atektickting.databinding.ActivityMainBinding
import com.gtech.atektickting.util.Key
import com.gtech.atektickting.util.SharedResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

object NavBarController {

    @SuppressLint("SetTextI18n")
    fun setNavContent(activity: Activity, binding: ActivityMainBinding) {

        val resource = SharedResource(activity)
        val db = AtekDatabase.getInstance(activity)

        CoroutineScope(Dispatchers.Main).launch {

            activity.runOnUiThread {
                binding.Version.text = "VERSION: " + BuildConfig.VERSION_NAME
            }

            if (resource.getBoolDataData(Key.IS_CONFIGURED)) {
                val equipment = db.equipmentDao().getEquipment()
                val station = db.stationDao().getStation(equipment.station_id.toInt())
                activity.runOnUiThread {
                    binding.DeviceId.text = "DEVICE ID: " + equipment.equipment_id
                    binding.SourceStation.text = station.station_name.uppercase()
                }
            }

            if (resource.getBoolDataData(Key.IS_LOGIN)) {
                val shiftId = resource.getIntDataData(Key.SHIFT_ID)
                val userId = resource.getStringDataData(Key.USER_NAME)
                activity.runOnUiThread {
                    binding.ShiftID.text = "SHIFT ID: $shiftId"
                    binding.User.text = "USER ID: $userId"
                }
            }

            activity.runOnUiThread {
                val dateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)
                dateFormat.timeZone = TimeZone.getTimeZone("GMT+5:30")
                binding.CurrentDate.text = "DATE: " + dateFormat.format(Calendar.getInstance().time).toString()
            }
        }
    }
}