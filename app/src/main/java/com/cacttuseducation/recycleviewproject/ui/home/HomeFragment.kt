package com.cacttuseducation.recycleviewproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cacttuseducation.recycleviewproject.adapter.StudentAdapter
import com.cacttuseducation.recycleviewproject.databinding.FragmentHomeBinding
import com.cacttuseducation.recycleviewproject.model.Student

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfStudents = listOf(
            Student(1, "Sutdenti 1", 30, 7.7),
            Student(2, "Sutdenti 2", 31, 7.8),
            Student(3, "Sutdenti 3", 32, 7.9),
            Student(4, "Sutdenti 4", 33, 8.7),
            Student(5, "Sutdenti 5", 34, 9.7),
            Student(6, "Sutdenti 6", 35, 6.7),
            Student(7, "Sutdenti 7", 36, 5.7),
            )

        val adapter = StudentAdapter(listOfStudents)
        binding.rvStudents.layoutManager = LinearLayoutManager(requireContext()) // per vertical
 //       binding.rvStudents.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false) // per horizontal
        binding.rvStudents.adapter = adapter

        adapter.onItemClick = {
            Toast.makeText(requireContext(),"Student clicked is $it",Toast.LENGTH_LONG).show()
        }

    }

}