package com.example.recyclerasignaturas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(private val courses: List<Course>, private val onCourseClickListener: (Course) -> Unit):
RecyclerView.Adapter<CourseAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val course = courses[position]
        val courseTextView: TextView = holder.itemView.findViewById(R.id.courseNameTextView)

        courseTextView.text = course.name

        holder.itemView.setOnClickListener{
            onCourseClickListener(course)
        }
    }

    override fun getItemCount(): Int = courses.size
}