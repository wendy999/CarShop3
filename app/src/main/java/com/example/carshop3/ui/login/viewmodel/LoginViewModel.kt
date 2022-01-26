package com.example.carshop3.ui.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carshop3.data.model.User
import com.example.carshop3.data.model.VehiculoModel
import com.example.carshop3.databinding.ActivityLoginBinding
import com.example.carshop3.domain.UserAplication.Companion.prefs

class LoginViewModel: ViewModel() {

    val buttonLoguin= MutableLiveData<User>().apply {
        //value = User(prefs.getName(), prefs.getPass())
    }



}