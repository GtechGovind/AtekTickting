package com.gtech.atektickting.util

interface NetworkUi {
    fun loading(isLoading: Boolean)
    fun onError(message: Enums.ERROR)
}