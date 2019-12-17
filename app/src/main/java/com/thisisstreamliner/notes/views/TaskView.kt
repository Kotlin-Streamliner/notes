package com.thisisstreamliner.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
    ) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView(task: Task) {
        this.task = task
        titleView.text = task.title
        task.todos.forEach { todo ->
            val todoView = (LayoutInflater.from(context).inflate(R.layout.todo_view, todoContainer, false) as TodoView).apply {
                initView(todo) {
                    if (isTaskComplete()) createStrikeThrough()
                    else removeStrikeThrough()
                }
            }
            todoContainer.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()

    private fun createStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        titleView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

}