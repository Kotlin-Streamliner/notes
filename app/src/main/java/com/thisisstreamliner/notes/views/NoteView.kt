package com.thisisstreamliner.notes.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.thisisstreamliner.notes.models.Note
import kotlinx.android.synthetic.main.todo_view.view.*

class NoteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(note: Note) {
        descriptionView.text = note.description
    }

}