package com.example.carshop3.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.carshop3.data.model.User
import com.example.carshop3.databinding.ActivityLoginBinding
import com.example.carshop3.domain.UserAplication.Companion.prefs
import com.example.carshop3.ui.PrincipalActivity
import com.example.carshop3.ui.detalleVehiculos.viewmodel.DetailViewModel
import com.example.carshop3.ui.login.viewmodel.LoginViewModel
import com.example.carshop3.ui.perfil.view.PerfilBloqActivity
import com.example.carshop3.ui.vehiculosDisponibles.viewmodel.HomeViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var bindingLogin: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)
        iniciarSesion(bindingLogin.root)
        //validarUsuario()
    }

    fun iniciarSesion(view: android.view.View) {
        bindingLogin.btnLogin.setOnClickListener{
            acces(view)
        }
    }

    fun acces(view: View){
        if (bindingLogin.usuarioLogin.text.toString().isNotEmpty()){
            prefs.saveUser(bindingLogin.usuarioLogin.text.toString())
            //prefs.savePass(bindingLogin.usuarioLogin.text.toString())
            irActivityprincipal()
        }else{
            Toast.makeText(this, "Por favor ingrese sus credenciales", Toast.LENGTH_SHORT).show()
        }
    }

    fun irActivityprincipal(){
        viewModel!!.buttonLoguin.value = User(prefs.getNombre(), prefs.getReferencia(),bindingLogin.usuarioLogin.text.toString(),bindingLogin.contraseALogin.text.toString())

        viewModel!!.buttonLoguin.observe(this, Observer{
            val args = Bundle()
            args.putString("cedula",it.cedula)
            args.putString("clave", it.clave)
            args.putString("nombre",it.nombre)
            args.putString("recidencia",it.direccion)

            /*if (it.cedula == prefs.getName()){
                startActivity(Intent(this,PrincipalActivity::class.java))
                finish()
            }*/

            val intent = Intent(this, PerfilBloqActivity::class.java)
            intent.putExtras(args)
            startActivity(intent)
            finish()
        })
    }


    fun validarUsuario(){
        if(prefs.getName().isNotEmpty()){
            startActivity(Intent(this,PrincipalActivity::class.java))
            finish()
        }
    }

}

