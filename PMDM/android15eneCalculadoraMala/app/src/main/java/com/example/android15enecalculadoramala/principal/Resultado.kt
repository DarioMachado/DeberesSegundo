package com.example.android15enecalculadoramala.principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android15enecalculadoramala.R

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultado: Double? = intent.extras?.getDouble("resultado")

        val tvResultado: TextView = findViewById<TextView>(R.id.resultado)

        tvResultado.text = "$resultado"
    }
}