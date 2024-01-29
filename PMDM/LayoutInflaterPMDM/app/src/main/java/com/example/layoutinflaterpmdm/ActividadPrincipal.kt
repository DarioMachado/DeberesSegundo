package com.example.layoutinflaterpmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ActividadPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_actividad_principal, null)

        val linearLayout = rootView.findViewById<LinearLayout>(R.id.layout)
        setContentView(rootView)

        val nuevoTextView = TextView(this)
        nuevoTextView.text = "Este text view fue añadido gracias al inflater"
        linearLayout.addView(nuevoTextView)


        val imagen = ImageView(this)
        imagen.setImageResource(R.mipmap.perro_foreground)
        imagen.maxWidth = 100
        imagen.maxHeight = 100
        linearLayout.addView(imagen)

        val editText = EditText(this)
        linearLayout.addView(editText)
    }


}


