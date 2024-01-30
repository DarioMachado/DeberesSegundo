package com.example.recyclerpmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personList = generatePersonList()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val personAdapter = PersonAdapter(personList)
        recyclerView.adapter = personAdapter
    }

    private fun generatePersonList(): List<Person>{
        return listOf(
            Person("Alberto", "Ruiz", "Calle Falsa 123", "Málaga"),
            Person("Juan", "José", "Calle Islas Canarias", "Málaga"),
            Person("Eva", "Smith", "Broadway", "Nueva York"),
            Person("Rosa", "Smith", "Broadway", "Nueva York"),
            Person("Laura", "García", "Gran vía", "Madrid"),
            Person("Cristina", "Epstein", "Isla", "Pacífico"),
            Person("Isabel", "Pantoja", "Cárcel", "Carcelandia"),



        )

    }
}