package com.example.carshop3.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.carshop3.R
import com.example.carshop3.databinding.ActivityLoginBinding
import com.example.carshop3.databinding.ActivityPrincipalBinding
import com.example.carshop3.domain.UserAplication.Companion.prefs
import com.example.carshop3.ui.PrincipalActivity
import com.example.carshop3.ui.perfil.PerfilBloqActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var bindingLogin: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)
        iniciarSesion(bindingLogin.root)
        //validarUsuario()
    }

    fun iniciarSesion(view: android.view.View) {
        bindingLogin.btnLogin.setOnClickListener{
            acces()
        }
    }

    fun acces(){
        if (bindingLogin.usuarioLogin.text.toString().isNotEmpty()){
            prefs.saveUser(bindingLogin.usuarioLogin.text.toString())
            //prefs.savePass(bindingLogin.usuarioLogin.text.toString())
            irActivityprincipal()
        }else{
            Toast.makeText(this, "Por favor ingrese sus credenciales", Toast.LENGTH_SHORT).show()
        }
    }

    fun irActivityprincipal(){
        startActivity(Intent(this,PerfilBloqActivity::class.java))
        finish()
    }

    fun validarUsuario(){
        if(prefs.getName().isNotEmpty()){
            startActivity(Intent(this,PrincipalActivity::class.java))
            finish()
        }
    }

}

