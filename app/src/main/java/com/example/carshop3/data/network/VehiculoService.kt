package com.example.carshop3.data.network

import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class VehiculoService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getvehiculos():List<VehiculoModel>{
        return withContext(Dispatchers.IO){// Ejecutamos lo siguiente en un hilo secundario para no recargar la interface del usuario
            val response:Response<List<VehiculoModel>> = retrofit.create(VehiculoApiClient::class.java).getAllVehiculos() //conectamos con retrofit
            response.body() ?: emptyList()
        }

    }
}