package com.example.carshop3.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.carshop3.R
import com.example.carshop3.ui.perfil.PerfilBloqActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun iniciarSesion(view: android.view.View) {
        val button: Button = findViewById(R.id.btn_Login)

        button.setOnClickListener{
            val intent2 = Intent(this,PerfilBloqActivity::class.java)
            startActivity(intent2)
            finish()
        }
    }
}

