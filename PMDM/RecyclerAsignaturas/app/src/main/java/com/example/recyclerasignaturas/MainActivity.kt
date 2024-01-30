package com.example.recyclerasignaturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val courses = listOf(Course("1 DAM", listOf(Subject("Programación"), Subject("Bases de datos"), Subject("Redes"))),
    Course("2 DAM", listOf(Subject("Desarrollo Web"), Subject("Seguridad"), Subject("Empresa")))
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerViewCourses: RecyclerView = findViewById(R.id.recyclerViewCourses)
        recyclerViewCourses.layoutManager = LinearLayoutManager(this)
        recyclerViewCourses.adapter = CourseAdapter(courses){
            course -> showSubjectDialog(course)
        }
    }
    private fun showSubjectDialog(course: Course){
        val subjects = course.subjects.map { it.name }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle("Asignaturas de ${course.name}")
            .setItems(subjects) { _, _ -> //aaaa
            }
            .setPositiveButton("Aceptar"){dialog, _ ->
                dialog.dismiss()
            }
            .create().show()
    }

}