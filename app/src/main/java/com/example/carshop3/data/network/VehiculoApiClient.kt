package com.example.carshop3.data.network

import com.example.carshop3.data.model.VehiculoModel
import retrofit2.Response
import retrofit2.http.GET

interface VehiculoApiClient {
    @GET("/.json")
    suspend fun getAllVehiculos():Response<List<VehiculoModel>>
}