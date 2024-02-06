package com.example.retoficherosandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.OutputStreamWriter

class Reto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto)

        val crear: Button = findViewById<Button>(R.id.crear)

        crear.setOnClickListener{
            crearArchivo()
        }
        val ir: Button = findViewById(R.id.irABuscar)

        ir.setOnClickListener {
            var intent = Intent(this, Buscar::class.java)
            startActivity(intent);
        }


    }

    fun crearArchivo(){
        try {
            val titulo: TextView = findViewById<TextView>(R.id.titulo)
            val contenido: TextView = findViewById(R.id.contenido)

            var osw: OutputStreamWriter =
                OutputStreamWriter(openFileOutput(titulo.text.toString(), Context.MODE_PRIVATE))
            osw.write(contenido.text.toString())
            Log.d("Yup", "Archivo creado")
            osw.flush()
            osw.close()
            Toast.makeText(this, "Archivo creado", Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            Toast.makeText(this, "Ha habido un error al crear el archivo", Toast.LENGTH_LONG).show()

        }
    }



}