package com.example.carshop3.data.model

import com.google.gson.annotations.SerializedName

class LoginUser (@SerializedName("user") var usuario: ArrayList<User>) {

}

data class User(
    @SerializedName("nombre") var nombre:String,
    @SerializedName("direccion") var direccion:String,
    @SerializedName("cedula") var cedula:String,
    @SerializedName("clave") var clave: String){

}