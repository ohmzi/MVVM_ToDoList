package com.ui.notes

import androidx.lifecycle.ViewModel
import com.Data.Note
import com.Data.repository

class QuotesViewModel(private val noteRepository: repository) : ViewModel() {

    fun getNodes() = noteRepository.getNodes()

    fun addNote(quote: Note) = noteRepository.addNote(quote)
}