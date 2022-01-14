package com.example.carshop3.domain

import android.app.Application
import com.example.carshop3.ui.login.view.Prefs

//Todo lo que este dentro de esta clase se ejecutaea en toda la aplicaciòn

class UserAplication:Application() {

    companion object{
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}
