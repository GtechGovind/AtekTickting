package com.gtech.atektickting.controller

import android.app.Activity
import com.gtech.atektickting.database.AtekDatabase
import com.gtech.atektickting.database.entity.*
import com.gtech.atektickting.model.configure.ConfigResponse
import com.gtech.atektickting.util.ControllerService
import com.gtech.atektickting.util.Key
import com.gtech.atektickting.util.SharedResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConfigController(private val service: ControllerService) {

    init {
        service.onStartController()
    }

    fun insertDataIntoLocalDatabase(response: ConfigResponse, activity: Activity) {

        val instance = AtekDatabase.getInstance(activity)

        CoroutineScope(Dispatchers.IO).launch {

            // CLEAR ALL TABLE
            instance.clearAllTables()

            // USERS
            for (user in response.users) {
                instance.userDao().insert(
                    user = User(
                        user_id = user.user_id,
                        user_name = user.user_name,
                        email = user.email,
                        operator_id = user.operator_id,
                        password = user.password,
                        phone = user.phone,
                        surname = user.surname
                    )
                )
            }

            // PRODUCTS
            for (product in response.products) {
                instance.productDao().insert(
                    product = Product(
                        pass_inventory_id = product.pass_inventory_id,
                        support_type_id = product.support_type_id,
                        pass_id = product.pass_id,
                        active = product.active,
                        name = product.name,
                        company_id = product.company_id,
                        description = product.description,
                        qr_type_id = product.qr_type_id,
                        same_station_over_time = product.same_station_over_time,
                        same_station_over_time_penalty = product.same_station_over_time_penalty,
                        same_station_over_time_max_penalty = product.same_station_over_time_max_penalty,
                        other_station_over_time = product.other_station_over_time,
                        other_station_over_time_penalty = product.other_station_over_time_penalty,
                        other_station_over_time_max_penalty = product.other_station_over_time_max_penalty,
                        over_travelling_penalty = product.over_travelling_penalty,
                        entry_exit_control = product.entry_exit_control,
                        start_validity_period = product.start_validity_period,
                        end_validity_period = product.end_validity_period as String,
                        balance_forward = product.balance_forward,
                        reload_permit = product.reload_permit,
                        validity = product.validity,
                        validity_unit = product.validity_unit,
                        entry_validity = product.entry_validity,
                        entry_validity_unit = product.entry_validity_unit,
                        grace_period = product.grace_period as String,
                        fare_table_id = product.fare_table_id,
                        fare_table_peak = product.fare_table_peak as String,
                        fare_table_non_peak = product.fare_table_non_peak as String,
                        registration_fee = product.registration_fee as String,
                        refund_permit = product.refund_permit,
                        refund_fee = product.refund_fee,
                        registration_fee_refund_permit = product.registration_fee_refund_permit,
                        registration_refund_fee = product.registration_refund_fee,
                        bundle_trips = product.bundle_trips as String,
                        daily_trip_control = product.daily_trip_control,
                        max_daily_trip = product.max_daily_trip as String,
                        max_balance = product.max_balance as String,
                        min_entry_value = product.min_entry_value as String,
                        max_exit_value = product.max_exit_value as String,
                        min_load_balance = product.min_load_balance as String,
                        min_reload_balance = product.min_reload_balance as String,
                        steps_reload = product.steps_reload as String,
                        cchs_reference = product.cchs_reference as String,
                        entry_mismatch_penalty = product.entry_mismatch_penalty,
                        exit_mismatch_penalty = product.exit_mismatch_penalty,
                        free_exit_token_penalty = product.free_exit_token_penalty,
                        return_validity = product.return_validity,
                        return_validity_unit = product.return_validity_unit
                    )
                )
            }

            // EQUIPMENT
            instance.equipmentDao().insert(
                Equipment(
                    eq_type_id = response.equipment.eq_type_id.toInt(),
                    end_date = response.equipment.end_date as String,
                    station_id = response.equipment.station_id,
                    equipment_id = response.equipment.equipment_id,
                    status = response.status
                )
            )

            // STATIONS
            for (station in response.stations) {
                instance.stationDao().insert(
                    Station(
                        station_name = station.station_name,
                        station_name_marathi = station.station_name_marathi,
                        station_code = station.station_name_marathi
                    )
                )
            }

            // FARE
            for (fare in response.fares) {
                instance.fareDao().insert(
                    Fare(
                        source = fare.source.toInt(),
                        destination = fare.destination.toInt(),
                        fare_table_id = fare.fare_table_id.toInt(),
                        fare = fare.fare.toDouble()
                    )
                )
            }

            activity.runOnUiThread {
                service.onFinishController()
            }
        }
    }
}