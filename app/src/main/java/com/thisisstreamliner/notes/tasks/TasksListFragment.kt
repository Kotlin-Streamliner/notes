package com.thisisstreamliner.notes.tasks


import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.models.Task
import com.thisisstreamliner.notes.models.Todo
import kotlinx.android.synthetic.main.fragment_tasks_list.*


/**
 * A simple [Fragment] subclass.
 * Use the [TasksListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TasksListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(mutableListOf(
            Task("Testing One!", mutableListOf(
                Todo("Test One", true),
                Todo("Test Two")
            )),
            Task("Testing Two!")
        ))
        recyclerView.adapter = adapter
    }

    companion object {

        fun newInstance() = TasksListFragment()
    }

}
