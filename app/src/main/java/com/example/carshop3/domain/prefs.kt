package com.example.carshop3.ui.login.view

import android.content.Context

class Prefs(val context: Context) {

    val SHARED_NAME ="Mydtb"
    val SHARED_USER_NAME = "username"
    val FAVORITE = "favorito"
    val PASSWORD = "password"

    val storage = context.getSharedPreferences(SHARED_NAME,0)

    fun saveUser(nombre:String){
        storage.edit().putString(SHARED_USER_NAME,nombre).apply()
    }

    fun savePass(clave:String){
        storage.edit().putString(PASSWORD,clave).apply()
    }

    fun getPass():String{
        return storage.getString(PASSWORD,"")!!
    }

    fun sabeFab(favorito: Boolean){
        storage.edit().putBoolean(FAVORITE, favorito).apply()
    }

    fun getName():String{
        return storage.getString(SHARED_USER_NAME,"")!!
    }

    fun getfav():Boolean{
        return storage.getBoolean(FAVORITE,false)!!
    }
}