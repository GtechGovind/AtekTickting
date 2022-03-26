package com.gtech.atektickting.repository

import com.gtech.atektickting.model.configure.ConfigResponse
import com.gtech.atektickting.network.MApiController
import com.gtech.atektickting.util.Network

class ConfigRepository {

    suspend fun getConfiguration() {

        val response: Result<ConfigResponse> = MApiController
            .apiService
            .getConfigurations(
                Network.getIPAddress(true)
            )


    }

}