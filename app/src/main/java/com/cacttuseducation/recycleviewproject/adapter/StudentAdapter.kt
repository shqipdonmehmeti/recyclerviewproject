package com.cacttuseducation.recycleviewproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cacttuseducation.recycleviewproject.R
import com.cacttuseducation.recycleviewproject.model.Student

class StudentAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvStudentId.text = student.id.toString()
        holder.tvStudentFullName.text = student.fullName
        holder.tvStudentAge.text = student.age.toString()
        holder.tvStudentAvgGrade.text = student.averageGrade.toString()

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(student)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStudentId: TextView = itemView.findViewById(R.id.tvStudentId)
        val tvStudentFullName: TextView = itemView.findViewById(R.id.tvStudentFullName)
        val tvStudentAge: TextView = itemView.findViewById(R.id.tvStudentAge)
        val tvStudentAvgGrade: TextView = itemView.findViewById(R.id.tvStudentAvgGrade)


    }

    var onItemClick: ((Student) -> Unit?)? = null
}