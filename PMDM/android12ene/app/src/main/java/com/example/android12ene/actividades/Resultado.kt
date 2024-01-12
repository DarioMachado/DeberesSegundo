package com.example.android12ene.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android12ene.R

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val tvResultado = findViewById<TextView>(R.id.texto)
        var nombre = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResultado.text = "Hola, $nombre"

    }
}