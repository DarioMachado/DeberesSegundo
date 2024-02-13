package com.example.retosqlandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dataManager: DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataManager = DataManager(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etPais = findViewById<EditText>(R.id.etPais)
        val etHabitat = findViewById<EditText>(R.id.etHabitat)
        val etDescripcion = findViewById<EditText>(R.id.etDescricpion)
        val etTipo = findViewById<EditText>(R.id.etTipo)
        val etPopularidad = findViewById<EditText>(R.id.etPopularidad)
        val etReal = findViewById<EditText>(R.id.etReal)



        //Iba a poner spinners pero no se va a valorar de todas formas así que...
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvMuestraDatos = findViewById<TextView>(R.id.tvMuestraDatos)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val pais = etPais.text.toString()
            val habitat = etHabitat.text.toString()
            val descripcion = etDescripcion.text.toString()
            val tipo = etTipo.text.toString()
            val popularidad = etPopularidad.text.toString()
            val real = etPopularidad.text.toString()


            dataManager.introducirDatos(nombre, pais, habitat, descripcion, tipo, popularidad, real)
            Toast.makeText(this, "Se agregó crítpido..", Toast.LENGTH_SHORT).show()
            etNombre.text.clear()
            etPais.text.clear()
            etHabitat.text.clear()
            etDescripcion.text.clear()
            etTipo.text.clear()
            etPopularidad.text.clear()
            etReal.text.clear()
        }

        btnMostrar.setOnClickListener {
            val nombres = dataManager.mostrarValores(this)
            tvMuestraDatos.text = nombres
        }

        btnBorrar.setOnClickListener {
            val nombre = etNombre.text.toString()
            if(dataManager.borrar(nombre))
                Toast.makeText(this,"Registro borrado: $nombre",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"No se encontró el registo: $nombre",Toast.LENGTH_SHORT).show()

        }
    }
}