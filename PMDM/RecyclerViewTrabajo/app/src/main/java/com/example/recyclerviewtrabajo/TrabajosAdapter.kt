package com.example.recyclerviewtrabajo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrabajosAdapter(private val trabajos: List<Trabajos>, private val onTrabajosClickListener: (Trabajos) -> Unit):
    RecyclerView.Adapter<TrabajosAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val trabajo = trabajos[position]
        val trabajosTextView: TextView = holder.itemView.findViewById(R.id.courseNameTextView)

        trabajosTextView.text = trabajo.name

        holder.itemView.setOnClickListener{
            onTrabajosClickListener(trabajo)
        }
    }

    override fun getItemCount(): Int = trabajos.size
}