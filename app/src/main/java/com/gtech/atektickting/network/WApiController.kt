package com.gtech.atektickting.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WApiController {

    private const val BASE_URL = "https://test.api.com"

    private fun wApiController(): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    }

    val apiService: WApiService by lazy {
        wApiController().create(WApiService::class.java)
    }

}