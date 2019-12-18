package com.thisisstreamliner.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.foundation.BaseRecyclerAdapter
import com.thisisstreamliner.notes.models.Note
import com.thisisstreamliner.notes.navigation.NavigationActivity
import com.thisisstreamliner.notes.navigation.TouchActionDelegate
import com.thisisstreamliner.notes.views.NoteView
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
    noteList: MutableList<Note>,
    val touchActionDelegate: TouchActionDelegate
): BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO) NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
        else AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))


    class NoteViewHolder(view: View) : BaseViewHolder<Note>(view) {

        override fun onBind(item: Note) {
            (view as NoteView).initView(item)
        }

    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {

        override fun onBind(item: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)
            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }

    }
}