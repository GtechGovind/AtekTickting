package com.gtech.atektickting.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MApiController {

    private const val BASE_URL = "https://test.api.com"

    private fun mApiController(): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    }

    val apiService: MApiService by lazy {
        mApiController().create(MApiService::class.java)
    }

}