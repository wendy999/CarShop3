package com.example.carshop3.data.model

class LoginUser (private var cedula:Int, private var contrasena:String) {

    private fun getCedula():Int{ return this.cedula }
    private fun getContrasena():String{ return this.contrasena }

}