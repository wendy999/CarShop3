package com.example.carshop3.ui.detalleVehiculos.viewmodel

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carshop3.data.model.VehiculoModel
import com.squareup.picasso.Picasso


class DetailViewModel : ViewModel() {

    private val _imagenDetail= MutableLiveData<String>()
    val imagenDetail: LiveData<String> = _imagenDetail

    private val _marcaDetail= MutableLiveData<String>()
    val marcaDetail: LiveData<String> = _marcaDetail

    private val _modeloDetail=MutableLiveData<String>()
    val modeloDetail: LiveData<String> = _modeloDetail

    private val _coleccionDetail=MutableLiveData<String>()
    val coleccionDetail: LiveData<String> = _coleccionDetail

    private val _combustionDetail=MutableLiveData<String>()
    val combustionDetail: LiveData<String> = _combustionDetail

    private var _floatinActionButton=MutableLiveData<VehiculoModel>()
    val floatinActionButton: LiveData<VehiculoModel> = _floatinActionButton

    val FabDetail= MutableLiveData<Boolean>()
    val estadoDetail= MutableLiveData<String>()




    /*fun bindImageDetail(imagenDetail:String,detailImage:ImageView){
        _imagenDetail.value = imagenDetail
    }*/
}