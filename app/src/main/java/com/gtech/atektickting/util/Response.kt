package com.gtech.atektickting.util

import android.app.Activity
import retrofit2.Response

object Response {
    fun <T> isValidResponse(response: Response<T>, ui: NetworkUi, activity: Activity?): Boolean {
        return if (response.isSuccessful) {
            if (response.body() != null) {
                activity?.runOnUiThread {
                    ui.loading(false)
                }
                true
            } else {
                activity?.runOnUiThread {
                    ui.onError(Enums.ERROR.EMPTY_RESPONSE)
                }
                false
            }
        } else {
            activity?.runOnUiThread {
                ui.onError(Enums.ERROR.UN_SUCCESSFUL)
            }
            false
        }
    }
}