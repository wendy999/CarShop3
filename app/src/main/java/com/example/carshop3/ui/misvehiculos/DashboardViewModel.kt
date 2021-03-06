package com.example.carshop3.ui.misvehiculos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.ui.vehiculosDisponibles.view.ObtenerVehiculo
import com.example.carshop3.ui.vehiculosDisponibles.view.VehiculoAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    val lisVehiculos = listOf<VehiculoModel>()
    var vehiculo = mutableListOf<VehiculoModel>()
    val imagenButton= MutableLiveData<VehiculoModel>()

    init {
        vehiculo
        mostrarDatos()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text


    var listButton=MutableLiveData<VehiculoModel>()
    var adapter= MutableLiveData<VehiculoAdapter>()


    fun mostrarDatos(): List<VehiculoModel> {
        CoroutineScope(Dispatchers.IO).launch {
            var lisVehiculos = ObtenerVehiculo.vehiculo
            vehiculo.addAll(lisVehiculos)
            println("pruebaaaaaaaa "+vehiculo)
        }
        return lisVehiculos
    }


}