package com.example.recyclerviewtrabajo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


val trabajos = listOf(
    Trabajos("Programación", listOf(Subject("Programador de Android"), Subject("Gestor de BBDD"), Subject("Programador en Java"))),
    Trabajos("Diseño web", listOf(Subject("Especialista en Wordpress"), Subject("Técnico en JavaScript"), Subject("Especialista en PHP"))),
    Trabajos("Marketing digital", listOf(Subject("Especialista en SEO"), Subject("Técnico en SEM"), Subject("Especialista en redes sociales")))
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerViewCourses: RecyclerView = findViewById(R.id.recyclerViewCourses)
        recyclerViewCourses.layoutManager = LinearLayoutManager(this)
        recyclerViewCourses.adapter = TrabajosAdapter(trabajos){
                trabajo -> showSubjectDialog(trabajo)
        }
    }
    private fun showSubjectDialog(trabajo: Trabajos){
        val subjects = trabajo.subjects.map { it.name }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle("Asignaturas de ${trabajo.name}")
            .setItems(subjects) { _, _ -> //aaaa
            }
            .setPositiveButton("Aceptar"){dialog, _ ->
                dialog.dismiss()
            }
            .create().show()
    }

}