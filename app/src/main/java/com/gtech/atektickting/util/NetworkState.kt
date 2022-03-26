package com.gtech.atektickting.util

interface NetworkState {
    fun loading(isLoading: Boolean)
    fun onError(message: Enums.ERROR)
}