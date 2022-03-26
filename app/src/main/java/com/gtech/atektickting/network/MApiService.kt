package com.gtech.atektickting.network

import com.gtech.atektickting.model.configure.ConfigResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MApiService {

    @FormUrlEncoded
    @POST("getConfigurations.php")
    suspend fun getConfigurations(@Field("device_ip") ip: String): Response<ConfigResponse>

}