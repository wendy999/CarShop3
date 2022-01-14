package com.example.carshop3.ui.perfil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.carshop3.R
import com.example.carshop3.databinding.ActivityLoginBinding
import com.example.carshop3.databinding.ActivityPerfilBloqBinding
import com.example.carshop3.ui.PrincipalActivity

class PerfilBloqActivity : AppCompatActivity() {

    private lateinit var bindingPerfil: ActivityPerfilBloqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingPerfil = ActivityPerfilBloqBinding.inflate(layoutInflater)
        setContentView(bindingPerfil.root)
    }

    fun datosLoguin(){
        val contrasena_login: EditText = findViewById(R.id.contraseña_login)
        val usuario_login: EditText = findViewById(R.id.usuario_login)
        val contrasena: EditText = findViewById(R.id.contraseña)
        val usuario: EditText = findViewById(R.id.cedula)
    }

    fun guardarDatos(view: android.view.View) {
        irActividad()
    }

    fun irActividad(){
        bindingPerfil.guardarInfo.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}