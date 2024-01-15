package com.example.ciclodevida.Principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ciclodevida.R

class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Ciclo de vida", "Se creó la primera actividad")
    }


    override fun onStart(){
        super.onStart()
        Log.d("Ciclo de vida", "Empezó la primera actividad")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo de vida", "Se reanudó la primera actividad")
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


    fun cambiarActividad(view: View){
        val intent = Intent(this, Actividad2::class.java)
        startActivity(intent)
    }

}