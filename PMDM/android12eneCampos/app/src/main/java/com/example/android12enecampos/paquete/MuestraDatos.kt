package com.example.android12enecampos.paquete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android12enecampos.R

class MuestraDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muestra_datos)


        val nombre: String = intent.extras?.getString("nombre").orEmpty()
        val apellidos: String = intent.extras?.getString("apellidos").orEmpty()
        val curso: String = intent.extras?.getString("curso").orEmpty()
        val asignatura: String = intent.extras?.getString("asignatura").orEmpty()
        val nota: String = intent.extras?.getString("nota").orEmpty()

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        tvNombre.text = "Hola, $nombre"

        val muestra = findViewById<TextView>(R.id.muestra)
        muestra.text = "Detalles: " +
                "\nApellidos: $apellidos" +
                "\nCurso: $curso" +
                "\nAsignatura: $asignatura" +
                "\nNota: $nota"

    }
}