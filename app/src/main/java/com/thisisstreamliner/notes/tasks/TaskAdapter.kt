package com.thisisstreamliner.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.foundation.BaseRecyclerAdapter
import com.thisisstreamliner.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.todo_view.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
): BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {

        override fun onBind(item: Task) {
            view.titleView.text = item.title

            item.todos.forEach { todo ->
                LayoutInflater.from(view.context).inflate(R.layout.todo_view, view.todoContainer, false).apply {
                    descriptionView.text = todo.description
                    completeCheckBox.isChecked = todo.isComplete
                    view.todoContainer.addView(this)
                }
            }
        }
    }

}