package com.example.aplicacionsimulacro

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import java.io.OutputStreamWriter
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView: CardView = findViewById(R.id.cardView)

        val rotacion: Animation = AnimationUtils.loadAnimation(this, R.anim.rotation)


        cardView.startAnimation(rotacion)
        val transparencia: Animation = AnimationUtils.loadAnimation(this, R.anim.transparency)
        val pussy2: TextView = findViewById(R.id.textView2)
        val pussy3: TextView = findViewById(R.id.textView3)

        pussy2.startAnimation(transparencia)
        pussy3.startAnimation(transparencia)

        val entrar: Button = findViewById(R.id.entrar)

        val etNombre: EditText = findViewById(R.id.editText)
        val slide: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_in)

        entrar.startAnimation(slide)
        etNombre.startAnimation(slide)

        entrar.setOnClickListener {
            try{
                val nombre = etNombre.text.toString()
                val fechaActual = LocalDate.now()
                val fileName = "nombres"
                val fileContent = "$nombre, $fechaActual"
                var osw = OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE))
                osw.write(fileContent)
                osw.flush()
                osw.close()
                Log.d("Éxito", "Todo ha salido bien")
                Toast.makeText(this, "Tu nombre se ha introducido correctamente", Toast.LENGTH_LONG).show()
                pussyvideo()
            } catch (e: Exception){
                Log.e("Error", "Error al usar el OutputStreamWriter: " + e.message)
            }
        }

    }

    fun pussyvideo(){
        val intent: Intent = Intent(this, FreePussyVideo::class.java)
        startActivity(intent)
    }
}