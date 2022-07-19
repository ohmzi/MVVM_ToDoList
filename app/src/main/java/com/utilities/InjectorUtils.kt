package com.utilities

import com.Data.database
import com.Data.repository
import com.ui.notes.viewModelProvider

object InjectorUtils {

    fun viewModelProvider(): viewModelProvider {
        val noteRepository = repository.getInstance(database.getInstance().noteDao)
        return viewModelProvider(noteRepository)
    }
}