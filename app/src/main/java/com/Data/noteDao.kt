package com.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class noteDao {
    private val noteList = mutableListOf<Note>()
    private val notes = MutableLiveData<List<Note>>()

    init {
        notes.value = noteList
    }

    fun addNote(note: Note) {
        noteList.add(note)
        notes.value = noteList
    }

    fun getNodes() = notes as LiveData<List<Note>>
}