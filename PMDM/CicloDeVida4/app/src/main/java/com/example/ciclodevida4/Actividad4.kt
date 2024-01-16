package com.example.ciclodevida4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Actividad4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad4)

        Log.d("Ciclo de vida", "Se creó la cuarta actividad")
    }


    override fun onStart(){
        super.onStart()
        Log.d("Ciclo de vida", "Empezó la cuarta actividad")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo de vida", "Se reanudó la cuarta actividad")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Ciclo de vida", "Se pausó la cuarta actividad")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ciclo de vida", "Se ha detenido la cuarta actividad")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Ciclo de vida", "Se reinició la cuarta actividad")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo de vida", "Se ha destruido la cuarta actividad")
    }


}