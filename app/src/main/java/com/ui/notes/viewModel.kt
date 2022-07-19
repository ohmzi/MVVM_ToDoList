package com.ui.notes

import androidx.lifecycle.ViewModel
import com.Data.Note
import com.Data.repository

class notesViewModel(private val noteRepository: repository) : ViewModel() {

    fun getNodes() = noteRepository.getNodes()

    fun addNote(note: Note) = noteRepository.addNote(note)
}