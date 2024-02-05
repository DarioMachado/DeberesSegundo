package com.example.ficherosandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader

class Leer : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leer)
        val tvLeer: TextView = findViewById(R.id.texto)
        val bLeer: Button = findViewById(R.id.leer)

        bLeer.setOnClickListener{
            leerArchivo(tvLeer)
        }

    }

    private fun leerArchivo(tvLeer: TextView){
        try{
            val fileName = "AWAWAWAWA"
            val br = BufferedReader(InputStreamReader(openFileInput(fileName)))
            val texto = br.readLine()
            br.close()
            tvLeer.text = texto

            Log.d("Éxito", "Contenido del archivo: $texto")


        } catch (e: Exception){
            Log.e("Error", "Ha habido un error al leer el archivo ${e.message}")
        }
    }
}