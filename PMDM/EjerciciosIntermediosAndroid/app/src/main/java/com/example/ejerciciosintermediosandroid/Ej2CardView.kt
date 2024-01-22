package com.example.ejerciciosintermediosandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.slider.RangeSlider

class Ej2CardView : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej2_card_view)

        val rangeSlider: RangeSlider = findViewById<RangeSlider>(R.id.rangoEdad)
        val tvEdad: TextView = findViewById<TextView>(R.id.tvEdad) //Qué difícil era, no?
        rangeSlider.addOnChangeListener { _, value, fromUser ->
            tvEdad.text = "${value.toInt()} AÑOS"
        }

    }
}