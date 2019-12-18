package com.thisisstreamliner.notes.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.foundation.BaseRecyclerAdapter
import com.thisisstreamliner.notes.models.Task
import com.thisisstreamliner.notes.navigation.NavigationActivity
import com.thisisstreamliner.notes.navigation.TouchActionDelegate
import com.thisisstreamliner.notes.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf(),
    val touchActionDelegate: TouchActionDelegate
): BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO) TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
        else AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))


    class TaskViewHolder(view: View) : BaseViewHolder<Task>(view) {

        override fun onBind(item: Task) {
            (view as TaskView).initView(item)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {

        override fun onBind(item: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)
            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_TASK)
            }
        }

    }

}