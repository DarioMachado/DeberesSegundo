package com.example.retoficherosandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader

class Buscar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        val buscar: Button = findViewById(R.id.buscar)

        buscar.setOnClickListener {
            buscarArchivo()
        }

    }
    fun buscarArchivo(){
        try{
        val archivo: TextView = findViewById(R.id.archivo)

        val br = BufferedReader(InputStreamReader(openFileInput(archivo.text.toString())))
        val texto = br.readLine()
        br.close()
        val aqui: TextView = findViewById(R.id.aqui)
        aqui.text = texto

        Log.d("Éxito", "Contenido del archivo: $texto")
        }catch (e: Exception){
            Toast.makeText(this, "Ha habido un error, es posible que ese archivo no exista", Toast.LENGTH_LONG).show()
        }
    }


}