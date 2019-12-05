package com.thisisstreamliner.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thisisstreamliner.notes.R
import com.thisisstreamliner.notes.foundation.BaseRecyclerAdapter
import com.thisisstreamliner.notes.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(
    noteList: MutableList<Note>
): BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Note>(view) {

        override fun onBind(item: Note) {
            view.titleView.text = item.description
        }

    }
}