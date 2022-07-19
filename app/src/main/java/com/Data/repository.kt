package com.Data


class repository private constructor(private val localNoteDao: noteDao) {

    fun addNote(note: Note) {
        localNoteDao.addNote(note)
    }

    fun getNodes() = localNoteDao.getNodes()

    companion object {
        @Volatile
        private var instance: repository? = null

        fun getInstance(localNoteDao: noteDao) =
            instance ?: synchronized(this) {
                instance ?: repository(localNoteDao).also { instance = it }
            }
    }
}