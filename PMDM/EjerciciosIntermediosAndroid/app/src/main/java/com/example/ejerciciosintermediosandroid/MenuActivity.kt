package com.example.ejerciciosintermediosandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }



    fun irAEj2(view: View){
        val intent = Intent(this, Ej2CardView::class.java)
        startActivity(intent)
    }
}