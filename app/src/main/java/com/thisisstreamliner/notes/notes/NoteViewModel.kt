package com.thisisstreamliner.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thisisstreamliner.notes.models.Note

class NoteViewModel : ViewModel() {

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        _noteListLiveData.value = getFakeData()
    }

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note description 1"),
        Note("Note description 2")
    )

}