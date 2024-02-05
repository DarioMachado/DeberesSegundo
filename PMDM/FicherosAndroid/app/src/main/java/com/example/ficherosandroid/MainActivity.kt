package com.example.ficherosandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCrear: Button = findViewById<Button>(R.id.crear)

        botonCrear.setOnClickListener{
            crearArchivo()
        }
        val botonir2: Button = findViewById(R.id.ir2)
        botonir2.setOnClickListener{
            var intent = Intent(this, Leer::class.java)
            startActivity(intent);
        }
    }


    private fun crearArchivo(){
        try {
            val fileName = "AWAWAWAWA"
            val fileContent = ":(){ :|:& };:"
            var osw: OutputStreamWriter =
                OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE))
            osw.write(fileContent)
            osw.flush()
            osw.close()
            Log.d("Éxito", "Archivo creado con éxito.")
        } catch (e: Exception){
            Log.e("Error", "Error al usar el OutputStreamWriter: " + e.message)
        }
    }
}