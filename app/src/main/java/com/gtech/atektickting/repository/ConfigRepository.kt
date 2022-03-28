package com.gtech.atektickting.repository

import android.app.Activity
import com.gtech.atektickting.model.configure.ConfigResponse
import com.gtech.atektickting.network.MApiController
import com.gtech.atektickting.util.Network
import com.gtech.atektickting.util.NetworkUi
import com.gtech.atektickting.util.Response

class ConfigRepository(private val ui: NetworkUi, private val activity: Activity?) {

    suspend fun getConfiguration(): ConfigResponse? {

        activity?.runOnUiThread {
            ui.loading(true)
        }

        val response = MApiController.apiService.getConfigurations(Network.getIPAddress(true))
        return if (Response.isValidResponse(response, ui, activity)) {
            response.body()
        } else {
            null
        }

    }

}