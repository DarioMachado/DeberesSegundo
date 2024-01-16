package com.example.ciclodevidainventado

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import kotlin.random.Random

class ActividadInventada2 : AppCompatActivity() {

    var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_inventada2)


        Log.d("Ciclo de vida", "Se creó la primera actividad")

    }


    override fun onStart() {
        super.onStart()
        Log.d("Ciclo de vida", "Empezó la primera actividad")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo de vida", "Se reanudó la primera actividad")
        var rng = Random.nextInt(16777215)
        var color = Integer.toString(rng, 16)
        window.decorView.setBackgroundColor(Color.parseColor("#"+color))


    }

    override fun onPause() {
        super.onPause()
        Log.d("Ciclo de vida", "Se pausó la primera actividad")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ciclo de vida", "Se ha detenido la primera actividad")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Ciclo de vida", "Se reinició la primera actividad")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo de vida", "Se ha destruido la primera actividad")
    }


    fun irA1(view: View) {
        val intent = Intent(this, ActividadInventada::class.java)

        startActivity(intent)
    }
}