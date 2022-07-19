package com.Data


class database private constructor() {

    var noteDao = noteDao()
        private set

    companion object {
        @Volatile
        private var instance: database? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: database().also { instance = it }
            }
    }
}