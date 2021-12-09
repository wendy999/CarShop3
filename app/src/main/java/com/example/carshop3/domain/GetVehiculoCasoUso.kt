package com.example.carshop3.domain

import com.example.carshop3.data.VehiRepositorio
import com.example.carshop3.data.model.VehiculoModel

class GetVehiculoCasoUso {

    private val  repositorio = VehiRepositorio()

    suspend operator fun invoke():List<VehiculoModel>? = repositorio.getAllVehiculos() // caso de uso llamara al repositorio
}