package com.example.carshop3.ui.perfil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.carshop3.R
import com.example.carshop3.ui.PrincipalActivity
import com.example.carshop3.ui.vehiculosDisponibles.DetailFragment
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class PerfilBloqActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_bloq)
    }

    fun datosLoguin(){

        val contrasena_login: EditText = findViewById(R.id.contraseña_login)
        val usuario_login: EditText = findViewById(R.id.usuario_login)

        val contrasena: EditText = findViewById(R.id.contraseña)
        val usuario: EditText = findViewById(R.id.cedula)
    }

    fun guardarDatos(view: android.view.View) {

        val button2: Button = findViewById(R.id.guardar_datos)

        button2.setOnClickListener {
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}