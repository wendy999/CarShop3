package com.example.carshop3.data

import com.example.carshop3.data.model.LocalRepositorio
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.data.network.VehiculoService

class VehiRepositorio {

    private val api = VehiculoService()

    suspend fun getAllVehiculos():List<VehiculoModel>{
        val response= api.getvehiculos() // El repositorio llamara al API
        LocalRepositorio.vehiculos = response
        return response
    }
}