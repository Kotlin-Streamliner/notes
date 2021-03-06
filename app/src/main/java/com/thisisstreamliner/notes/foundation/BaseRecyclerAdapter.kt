package com.thisisstreamliner.notes.foundation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thisisstreamliner.notes.tasks.TaskAdapter

abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf()
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(list: MutableList<T>) {
        masterList.clear()
        masterList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = masterList.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder) holder.onBind(Unit)
        else (holder as BaseViewHolder<T>).onBind(masterList[position - 1])
    }

    abstract class BaseViewHolder<E>(val view: View): RecyclerView.ViewHolder(view) {

        abstract fun onBind(item: E)

    }

    abstract class AddButtonViewHolder(view: View) : BaseViewHolder<Unit>(view)

    override fun getItemViewType(position: Int): Int = if (position == 0) TYPE_ADD_BUTTON else TYPE_INFO

    companion object {

        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1

    }
}