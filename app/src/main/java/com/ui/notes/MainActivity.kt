package com.ui.notes

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.Data.Note
import com.example.MVVM_ToDoList.R
import com.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView_notes.movementMethod = ScrollingMovementMethod()
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.viewModelProvider()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(notesViewModel::class.java)

        viewModel.getNodes().observe(this, Observer { notes ->
            val stringBuilder = StringBuilder()
            notes.forEach { notes ->
                stringBuilder.append("$notes\n\n")
            }
            textView_notes.text = stringBuilder.toString()
        })

        button_add_note.setOnClickListener {
            val notes = Note(editText_note.text.toString())
            viewModel.addNote(notes)
            editText_note.setText("")
        }
    }
}

