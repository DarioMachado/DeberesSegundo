package com.example.retocardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val clasificacion = intent.extras?.getString("clasificacion")
        val IMC = intent.extras?.getFloat("IMC")

        val tvClasificacion = findViewById<TextView>(R.id.clasificacion)
        tvClasificacion.text = clasificacion

        val tvIMC = findViewById<TextView>(R.id.IMC)
        tvIMC.text = IMC.toString()

        val tvExplicacion = findViewById<TextView>(R.id.explicacion)

        if (IMC != null) {
            if(IMC < 18.5F)
                tvExplicacion.text = "Estás muy por debajo de tu peso ideal"
            if(IMC >= 18.5F)
                tvExplicacion.text = "Tienes un peso normal"
            if(IMC >= 25F)
                tvExplicacion.text = "Estás por encima de tu peso ideal"
            if(IMC >=30F)
                tvExplicacion.text = "Estás muy por encima de tu peso ideal"
        }

    }
}