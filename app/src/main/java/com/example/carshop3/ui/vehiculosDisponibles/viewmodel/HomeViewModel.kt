package com.example.carshop3.ui.vehiculosDisponibles.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carshop3.core.RetrofitHelper
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.data.network.APIService
import com.example.carshop3.ui.vehiculosDisponibles.view.ObtenerVehiculo
import com.example.carshop3.ui.vehiculosDisponibles.view.VehiculoAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var vehiculo = mutableListOf<VehiculoModel>()
    var itemImage = MutableLiveData<String>()
    var itemMarca  = MutableLiveData<String>()
    var itemDetail = MutableLiveData<String>()
    val imagenButton= MutableLiveData<VehiculoModel>()
    val lisVehiculos = listOf<VehiculoModel>()

    init {
        vehiculo
        mostrarDatos()
    }

    var adapter= MutableLiveData<VehiculoAdapter>()

    fun bindImage(imagenDetail:String ){
        itemDetail.value = imagenDetail
    }

    fun mostrarDatos(): List<VehiculoModel> {
        CoroutineScope(Dispatchers.IO).launch {
            var lisVehiculos = ObtenerVehiculo.vehiculo
            vehiculo.addAll(lisVehiculos)
            println("pruebaaaaaaaa "+vehiculo)
        }
        return lisVehiculos
    }

    /*fun mostrarDatos2():List<VehiculoModel>{
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitHelper.getRetrofit().create(APIService::class.java).getVehiculos("d8c1c023-5ab7-413c-bbec-a3963ff3eed7")
            val vehiculoRet = call.body()

            val lisVehiculos= vehiculoRet?.vehiculo ?: emptyList()
            //vehiculo.addAll(lisVehiculos)
        }
        return  lisVehiculos
    }*/
}
