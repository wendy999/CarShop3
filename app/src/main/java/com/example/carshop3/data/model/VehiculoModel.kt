package com.example.carshop3.data.model

import com.google.gson.annotations.SerializedName

data class VehiclesList(@SerializedName("vehicles") val vehiculo: ArrayList<VehiculoModel>){}


data class VehiculoModel(
    @SerializedName("brand") var marca:String,
    @SerializedName("model") var modelo:Int,
    //@SerializedName("delet_requesth") var delet_requesth:Boolean,
    //@SerializedName("state") var estatus:String,
    //@SerializedName("favorite") var favorito:Boolean,
    @SerializedName("image") var imagen:String,
    //@SerializedName("location") var localizacion:Location ,
    //@SerializedName("collection_name") var coleccion:String,
    //@SerializedName("combustion_type") var combustion:String
    ){
}

data class Location(
    @SerializedName("address") var direccion:String,
    @SerializedName("latitude") var latitud:String,
    @SerializedName("latitude") var longitud:String,
){

}

