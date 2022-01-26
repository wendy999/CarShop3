package com.example.carshop3.ui.perfil.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.carshop3.databinding.ActivityPerfilBloqBinding
import com.example.carshop3.domain.UserAplication.Companion.prefs
import com.example.carshop3.ui.PrincipalActivity
import com.example.carshop3.ui.perfil.viewmodel.PerfilViewModel

class PerfilBloqActivity : AppCompatActivity() {

    private lateinit var bindingPerfil: ActivityPerfilBloqBinding
    private lateinit var viewModel:PerfilViewModel

    //Parametros del objeto
    var cedula:String? =null
    var clave:String? =null
    var nombre:String? =null
    var recidencia:String? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var recibirdatos: Intent = getIntent()

        cedula = recibirdatos.getStringExtra("cedula")
        clave = recibirdatos.getStringExtra("clave")
        nombre = recibirdatos.getStringExtra("nombre")
        recidencia = recibirdatos.getStringExtra("direcciom")

        println("esta es la cedulaaaaa "+cedula)
        viewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)


        bindingPerfil = ActivityPerfilBloqBinding.inflate(layoutInflater)
        setContentView(bindingPerfil.root)
        ObserverDatosLogin()
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

    fun ObserverDatosLogin(){
        viewModel.cedula.value = cedula
        viewModel.clave.value = clave
        viewModel.nombre.value = nombre
        viewModel.recidencia.value = recidencia

        viewModel.cedula.observe(this, Observer {
            bindingPerfil.cedula.hint = it
        })

        viewModel.clave.observe(this, Observer {
            bindingPerfil.clave.hint = it
        })

        viewModel.nombre.observe(this, Observer {
            bindingPerfil.clave.hint = it
        })

        if (viewModel.cedula.value == prefs.getName() && viewModel.clave.value == prefs.getPass()){
            println("lalalallalala")
        }
    }
}