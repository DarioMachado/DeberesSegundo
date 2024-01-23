package com.example.ejerciciosintermediosandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider

class Ej2CardView : AppCompatActivity() {

    private lateinit var tvIngresos: TextView
    private val incrementoIngresos = 100
    private lateinit var cardViewPulsado: String
    private lateinit var tvEdad: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej2_card_view)

        val rangeSlider: RangeSlider = findViewById<RangeSlider>(R.id.rangoEdad)
        tvEdad = findViewById<TextView>(R.id.tvEdad) //Qué difícil era, no?
        rangeSlider.addOnChangeListener { _, value, fromUser ->
            tvEdad.text = "${value.toInt()} AÑOS"
        }
        tvIngresos = findViewById<TextView>(R.id.ingresos)
    }

    fun cambiarIngresos(view: View){
        //Sinceramente creo que alguien de la empresa ve esto y me despide
        if(view.id == R.id.sumar)
            tvIngresos.text = (tvIngresos.text.toString().toInt()+incrementoIngresos).toString()
        else if(view.id == R.id.restar)
            tvIngresos.text = (tvIngresos.text.toString().toInt()-incrementoIngresos).toString()

        if(tvIngresos.text.toString().toInt() < 0)
            tvIngresos.text = "0"
    }

    fun elegirCardView(view: View){
        cardViewPulsado = view.resources.getResourceEntryName(view.id)
    }


    fun resultados(view: View){
        var intent: Intent = Intent(this, ResultadosCW::class.java)
        intent.putExtra("cwPulsado", cardViewPulsado)
        intent.putExtra("edad", tvEdad.text.toString())
        intent.putExtra("ingresos", tvIngresos.text.toString())
        startActivity(intent)
    }



}