package com.example.android15enecalculadoramala.principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.android15enecalculadoramala.R

class Operaciones : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operaciones)

        val sumar: Button = findViewById<Button>(R.id.sumar)
        val restar: Button = findViewById<Button>(R.id.restar)
        val multiplicar: Button = findViewById<Button>(R.id.multiplicar)
        val dividir: Button = findViewById<Button>(R.id.dividir)

        var op1: Double
        var op2: Double


        sumar.setOnClickListener(){
            op1 = findViewById<EditText>(R.id.op1).text.toString().toDouble()
            op2 = findViewById<EditText>(R.id.op2).text.toString().toDouble()
            if(op1 == null || op2 == null) return@setOnClickListener

            var resultado = op1 + op2
            enviar(resultado)
        }

        restar.setOnClickListener(){
            op1 = findViewById<EditText>(R.id.op1).text.toString().toDouble()
            op2 = findViewById<EditText>(R.id.op2).text.toString().toDouble()
            if(op1 == null || op2 == null) return@setOnClickListener

            var resultado = op1 - op2
            enviar(resultado)
        }

        multiplicar.setOnClickListener(){
            op1 = findViewById<EditText>(R.id.op1).text.toString().toDouble()
            op2 = findViewById<EditText>(R.id.op2).text.toString().toDouble()
            if(op1 == null || op2 == null) return@setOnClickListener

            var resultado = op1 * op2
            enviar(resultado)
        }

        dividir.setOnClickListener(){
            op1 = findViewById<EditText>(R.id.op1).text.toString().toDouble()
            op2 = findViewById<EditText>(R.id.op2).text.toString().toDouble()
            if(op1 == null || op2 == null || op2.toInt() ==0) return@setOnClickListener

            var resultado = op1 / op2
            enviar(resultado)
        }



    }


    fun enviar(enviar: Double){
        val intent = Intent(this, Resultado::class.java)
        intent.putExtra("resultado", enviar)
        startActivity(intent)
    }
}