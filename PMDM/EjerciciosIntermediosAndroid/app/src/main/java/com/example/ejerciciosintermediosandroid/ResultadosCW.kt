package com.example.ejerciciosintermediosandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadosCW : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados_cw)

        val ingresos = intent.extras?.getString("ingresos")
        val cwPulsado = intent.extras?.getString("cwPulsado")
        val edad = intent.extras?.getString("edad")


        val texto: String = "Ingresos: $ingresos euros al mes \nEdad: $edad años\nCardView elegida: $cwPulsado"

        val tvTexto: TextView = findViewById<TextView>(R.id.texto)

        tvTexto.text = texto
    }
}