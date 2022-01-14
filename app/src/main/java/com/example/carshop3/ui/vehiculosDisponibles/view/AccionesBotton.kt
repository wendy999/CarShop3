package com.example.carshop3.ui.vehiculosDisponibles.view

import com.example.carshop3.core.RetrofitHelper
import com.example.carshop3.data.model.VehiclesList
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.data.network.APIService
import com.example.carshop3.ui.vehiculosDisponibles.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
//var vehiculo: List<VehiculoModel>

class AccionesBotton{
    var vehiculo = mutableListOf<VehiculoModel>()

    init {
        this.vehiculo = mostrarDatos()
    }

    fun mostrarDatos(): MutableList<VehiculoModel> {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitHelper.getRetrofit().create(APIService::class.java).getVehiculos("d8c1c023-5ab7-413c-bbec-a3963ff3eed7")
            val vehiculoRet= call.body()

            val lisVehiculos:List<VehiculoModel> = vehiculoRet?.vehiculo?: emptyList()
            vehiculo.addAll(lisVehiculos)
        }
        return vehiculo
    }
}