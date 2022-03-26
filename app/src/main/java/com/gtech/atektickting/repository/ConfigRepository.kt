package com.gtech.atektickting.repository

import com.gtech.atektickting.model.configure.ConfigResponse
import com.gtech.atektickting.network.MApiController
import com.gtech.atektickting.util.Enums.ERROR.*
import com.gtech.atektickting.util.Network
import com.gtech.atektickting.util.NetworkState
import retrofit2.Response

class ConfigRepository(private val state: NetworkState) {

    init {
        if (Network.isConnected()) state.onError(NO_INTERNET)
    }

    suspend fun getConfiguration(): ConfigResponse? {
        state.loading(true)
        val response = MApiController.apiService.getConfigurations(Network.getIPAddress(true))
        return if (isValidResponse(response)) response.body()
        else null
    }

    private fun <T> isValidResponse(response: Response<T>): Boolean {
        state.loading(false)
        return if (response.isSuccessful) {
            if (response.body() != null) {
                true
            } else {
                state.onError(EMPTY_RESPONSE)
                false
            }
        } else {
            state.onError(UN_SUCCESSFUL)
            false
        }
    }

}