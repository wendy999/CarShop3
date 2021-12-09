package com.example.carshop3.data.network

import com.example.carshop3.data.model.VehiclesList
import com.example.carshop3.data.model.VehiculoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//Crear el metodo por medio del cual accedemos a nuestra API
interface APIService {
    @GET
    //Suspend es para las funciones que va a ejecutarce asincronamente
    suspend fun getVehiculos(@Url url:String):Response<VehiclesList>
}