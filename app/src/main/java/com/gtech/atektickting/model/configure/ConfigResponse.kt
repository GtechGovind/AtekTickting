package com.gtech.atektickting.model.configure

data class ConfigResponse(
    val equipment: Equipment,
    val fares: List<Fare>,
    val products: List<Product>,
    val stations: List<Station>,
    val status: Boolean,
    val users: List<User>
)