package com.example.calculadorabuena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
    }


    fun calculando(view: View){
        var boton: Button = view as Button
        concatenar(boton.text.toString())
    }

    fun concatenar(nuevo :String){
        val calculando = findViewById<TextView>(R.id.cuenta)
        calculando.text = calculando.text.toString()+nuevo
    }

    fun borrar(view: View){
        val calculando = findViewById<TextView>(R.id.cuenta)
        calculando.text = calculando.text.toString().dropLast(1)
    }

    fun calcular(view: View){
        val calculando = findViewById<TextView>(R.id.cuenta)
        var expresion: String = calculando.text.toString()

        if (!expresion.last().isDigit())
            return

        var listaNumeros = ArrayList<Double>()
        var listaOperaciones = ArrayList<String>()

        var invalido = false

        var constructor: String = ""
        for (char in expresion){


            if(char.isDigit()) {
                invalido=false
                constructor+=char
                continue
            }
            if(char == '.'){
                if(invalido)
                    return
                invalido = true
                constructor+=char
                continue
            }else{
                listaNumeros.add(constructor.toDouble())
                constructor=""
                if(invalido)
                    return
                invalido = true
                listaOperaciones.add(char+"")
            }

        }
        listaNumeros.add(constructor.toDouble())



        listaOperaciones.forEachIndexed{i, operacion ->
            if (operacion.equals("÷")) {
                listaNumeros[i+1] = listaNumeros.get(i) / listaNumeros.get(i+1)
                listaNumeros[i]  = 0.0
            }
            else if (operacion.equals("×")){
                listaNumeros[i+1] = listaNumeros.get(i) * listaNumeros.get(i+1)
                listaNumeros[i]  = 0.0
            }
        }
        listaOperaciones.forEachIndexed{i, operacion ->
            if (operacion.equals("+")) {
                listaNumeros[i+1] = listaNumeros.get(i) + listaNumeros.get(i+1)
                listaNumeros[i]  = 0.0
            }
            else if (operacion.equals("-")){
                listaNumeros[i+1] = listaNumeros.get(i) - listaNumeros.get(i+1)
                listaNumeros[i]  = 0.0
            }
        }

        val resultado = findViewById<TextView>(R.id.resultado)
        Log.d("aa",listaNumeros.toString())
        Log.d("aa",listaOperaciones.toString())
        resultado.text = ""+listaNumeros.sum()

    }




}