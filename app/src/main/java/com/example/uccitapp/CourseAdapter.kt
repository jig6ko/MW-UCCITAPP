package com.example.uccitapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(private var courses: List<Course>) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var codeTextView: TextView
         var nameTextView: TextView
         var creditsTextView: TextView
         var prerequisitesTextView: TextView
         var descriptionTextView: TextView

        init {
            codeTextView = itemView.findViewById(R.id.course_code)
            nameTextView = itemView.findViewById(R.id.course_name)
            creditsTextView = itemView.findViewById(R.id.course_credits)
            prerequisitesTextView = itemView.findViewById(R.id.course_prerequisites)
            descriptionTextView = itemView.findViewById(R.id.course_description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_course, parent, false)
        return ViewHolder(itemView)
    }

    fun setCourses(courses: List<Course>) {
        this.courses = courses
        notifyItemRangeChanged(0, courses.size)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses[position]
        holder.codeTextView.text = course.code
        holder.nameTextView.text = course.name
        holder.creditsTextView.text = "Credits: ${course.credits}"
        holder.prerequisitesTextView.text = "Prerequisites: ${course.prerequisites}"
        holder.descriptionTextView.text = course.description
    }

    override fun getItemCount() = courses.size
}