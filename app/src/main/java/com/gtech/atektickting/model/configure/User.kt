package com.gtech.atektickting.model.configure

data class User(
    val created_by: String,
    val description: String,
    val designation: String,
    val email: String,
    val employee_id: String,
    val end_date: String,
    val eq_profile: String,
    val isTester: String,
    val login: String,
    val modified_by: Any,
    val operator_id: String,
    val password: String,
    val pg_id: String,
    val phone: String,
    val remember_token: String,
    val secret_key: Any,
    val start_date: String,
    val status: String,
    val surname: String,
    val user_group_id: String,
    val user_id: String,
    val user_name: String
)