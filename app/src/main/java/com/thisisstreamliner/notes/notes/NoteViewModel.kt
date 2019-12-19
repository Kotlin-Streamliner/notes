package com.thisisstreamliner.notes.notes

import androidx.lifecycle.ViewModel
import com.thisisstreamliner.notes.models.Note

class NoteViewModel : ViewModel() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note description 1"),
        Note("Note description 2")
    )

}