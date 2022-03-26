package com.gtech.atektickting.model.configure

data class Product(
    val active: String,
    val balance_forward: String,
    val bundle_trips: Any,
    val cchs_reference: Any,
    val company_id: String,
    val daily_trip_control: String,
    val description: String,
    val end_validity_period: Any,
    val entry_exit_control: String,
    val entry_mismatch_penalty: String,
    val entry_validity: String,
    val entry_validity_unit: String,
    val exit_mismatch_penalty: String,
    val fare_table_id: String,
    val fare_table_non_peak: Any,
    val fare_table_peak: Any,
    val free_exit_token_penalty: String,
    val grace_period: Any,
    val max_balance: Any,
    val max_daily_trip: Any,
    val max_exit_value: Any,
    val min_entry_value: Any,
    val min_load_balance: Any,
    val min_reload_balance: Any,
    val name: String,
    val other_station_over_time: String,
    val other_station_over_time_max_penalty: String,
    val other_station_over_time_penalty: String,
    val over_travelling_penalty: String,
    val pass_id: String,
    val pass_inventory_id: String,
    val qr_type_id: String,
    val refund_fee: String,
    val refund_permit: String,
    val registration_fee: Any,
    val registration_fee_refund_permit: String,
    val registration_refund_fee: String,
    val reload_permit: String,
    val return_validity: String,
    val return_validity_unit: String,
    val same_station_over_time: String,
    val same_station_over_time_max_penalty: String,
    val same_station_over_time_penalty: String,
    val start_validity_period: String,
    val steps_reload: Any,
    val support_type_id: String,
    val validity: String,
    val validity_unit: String
)