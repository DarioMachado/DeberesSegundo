package com.example.retocardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images.ImageColumns
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import org.w3c.dom.Text

class EntradaDatos : AppCompatActivity() {

    private lateinit var sexo: String
    private var altura: Int = 120
    private var peso: Int = 70
    private var edad: Int = 30


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrada_datos)

        val rangoAltura: RangeSlider = findViewById<RangeSlider>(R.id.rangoAltura)
        val tvAltura: TextView = findViewById(R.id.altura)
        rangoAltura.addOnChangeListener{_, value,fromUser ->
            altura = value.toInt()
            tvAltura.text = "${value.toInt()} cm"
        }

    }

    fun elegirSexo(view: View){
        val botonHombre: CardView = findViewById<CardView>(R.id.hombre)
        val botonMujer: CardView = findViewById<CardView>(R.id.mujer)

        if(view.id == botonHombre.id){
            botonHombre.backgroundTintList = ContextCompat.getColorStateList(this, R.color.seleccionada)
            botonMujer.backgroundTintList = ContextCompat.getColorStateList(this, R.color.cartas)
            sexo = "Hombre" //Esto no se usa???
        }
        if(view.id == botonMujer.id){
            botonMujer.backgroundTintList = ContextCompat.getColorStateList(this, R.color.seleccionada)
            botonHombre.backgroundTintList = ContextCompat.getColorStateList(this, R.color.cartas)
            sexo = "Mujer"
        }
    }




    fun cambiarPeso(view: View){
        val masPeso: FloatingActionButton = findViewById<FloatingActionButton>(R.id.masPeso)
        val menosPeso: FloatingActionButton = findViewById<FloatingActionButton>(R.id.menosPeso)
        var tvPeso: TextView = findViewById<TextView>(R.id.peso)

        if(view.id == masPeso.id){
            peso = tvPeso.text.toString().toInt()+1
            tvPeso.text = peso.toString()

        }
        if(view.id == menosPeso.id){
            peso = tvPeso.text.toString().toInt()-1
            tvPeso.text = peso.toString()
        }

    }

    fun cambiarEdad(view: View){
        val masEdad: FloatingActionButton = findViewById<FloatingActionButton>(R.id.masEdad)
        val menosEdad: FloatingActionButton = findViewById<FloatingActionButton>(R.id.menosEdad)
        var tvEdad: TextView = findViewById<TextView>(R.id.edad)


        if(view.id == masEdad.id){
            peso = tvEdad.text.toString().toInt()+1
            tvEdad.text = peso.toString()

        }
        if(view.id == menosEdad.id){
            peso = tvEdad.text.toString().toInt()-1
            tvEdad.text = peso.toString()
        }
    }


    fun calcular(view: View){
        var clasificacion: String = ""

        var IMC: Float = (peso / ((altura*altura) /100F)) * 100
        IMC = String.format("%.2f", IMC).toFloat() //Esto es para redondearlo a 2 decimales
        Log.d("ASS", "$IMC")

        //Esto se llama cascada de ifs, seguirá haciendo ifs hasta que deje de hacerlos
        if(IMC < 18.5f)
            clasificacion = "Bajo peso"
        if(IMC > 18.5f)
            clasificacion = "Peso normal"
        if(IMC > 24.9f)
            clasificacion = "Sobrepeso"
        if(IMC > 29.9f)
            clasificacion = "Obesidad"

        val intent: Intent = Intent(this, Resultado::class.java)
        intent.putExtra("IMC", IMC)
        intent.putExtra("clasificacion", clasificacion)
        startActivity(intent)
    }

}