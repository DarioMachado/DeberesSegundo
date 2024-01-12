package com.example.android12enecampos.paquete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.android12enecampos.R

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val boton: Button = findViewById<AppCompatButton>(R.id.boton)

        boton.setOnClickListener(){
            var nombre: String = findViewById<AppCompatEditText>(R.id.nombre).text.toString()
            var apellidos: String = findViewById<AppCompatEditText>(R.id.apellidos).text.toString()
            var curso: String = findViewById<AppCompatEditText>(R.id.curso).text.toString()
            var asignatura: String = findViewById<AppCompatEditText>(R.id.asignatura).text.toString()
            var nota: String = findViewById<AppCompatEditText>(R.id.nota).text.toString()

            if(nombre.isNotEmpty()&& apellidos.isNotEmpty() && curso.isNotEmpty() && nota.isNotEmpty()){
                val intent = Intent(this, MuestraDatos::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("apellidos", apellidos)
                intent.putExtra("curso",curso)
                intent.putExtra("nota", nota)
                intent.putExtra("asignatura",asignatura)
                startActivity(intent)
            }


        }

    }
}