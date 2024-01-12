package com.example.android12ene.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.app.ActivityCompat
import com.example.android12ene.R

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var boton: Button = findViewById<AppCompatButton>(R.id.boton)

        boton.setOnClickListener(){
            var nombre: String = findViewById<AppCompatEditText>(R.id.nombre).text.toString()

            if(nombre.isNotEmpty()) {
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("EXTRA_NAME", nombre)
                startActivity(intent)
            }
        }
    }




}