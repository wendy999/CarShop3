package com.example.carshop3.ui.perfil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel: ViewModel(){

    val cedula= MutableLiveData<String>()
    val clave= MutableLiveData<String>()
    val nombre= MutableLiveData<String>()
    val recidencia= MutableLiveData<String>()

}