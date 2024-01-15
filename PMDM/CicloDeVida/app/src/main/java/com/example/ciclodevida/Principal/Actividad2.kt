package com.example.ciclodevida.Principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ciclodevida.R


class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        Log.d("Ciclo de vida", "Se creó la segunda actividad")
    }


    override fun onStart(){
        super.onStart()
        Log.d("Ciclo de vida", "Empezó la segunda actividad")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo de vida", "Se reanudó la segunda actividad")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Ciclo de vida", "Se pausó la segunda actividad")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ciclo de vida", "Se ha detenido la segunda actividad")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Ciclo de vida", "Se reinició la segunda actividad")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo de vida", "Se ha destruido la segunda actividad")
    }


    fun volver(view: View){
        val intent = Intent(this, Main::class.java)
        startActivity(intent)
    }

}