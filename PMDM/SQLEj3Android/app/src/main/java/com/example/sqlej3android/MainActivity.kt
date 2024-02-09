package com.example.sqlej3android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dataManager: DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataManager = DataManager(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDNI = findViewById<EditText>(R.id.etDNI)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val etCurso = findViewById<EditText>(R.id.etCurso)


        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvMuestraDatos = findViewById<TextView>(R.id.tvMuestraDatos)


        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()

            val dni = etDNI.text.toString()
            var edad = 0
            try {
                edad = etEdad.text.toString().toInt()
            }catch (e: Exception){
            }
            val curso = etCurso.text.toString()

            dataManager.introducirDatos(nombre, apellidos,dni,edad,curso)
            Toast.makeText(this, "Se agregó alumno..", Toast.LENGTH_SHORT).show()
            etNombre.text.clear()
            etApellidos.text.clear()
            etDNI.text.clear()
            etEdad.text.clear()
            etCurso.text.clear()
        }

        btnMostrar.setOnClickListener {
            // estamos instanciando la clase datamanager
            val nombres = dataManager.mostrarValores(this)
            tvMuestraDatos.text = nombres
        }
    }
}