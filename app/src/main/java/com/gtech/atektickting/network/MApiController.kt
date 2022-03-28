package com.gtech.atektickting.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MApiController {

    private const val BASE_URL = "http://10.13.3.8:8080/atek_backend/v1/"

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