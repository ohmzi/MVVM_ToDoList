package com.ui.notes

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.Data.Note
import com.example.MVVM_ToDoList.databinding.ActivityMainBinding
import com.utilities.InjectorUtils


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        binding.textViewNotes.movementMethod = ScrollingMovementMethod()
        setContentView(view)
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
            binding.textViewNotes.text = stringBuilder.toString()
        })

        binding.buttonAddNote.setOnClickListener {
            val notes = Note(binding.editTextNote.text.toString())
            viewModel.addNote(notes)
            binding.editTextNote.setText("")
        }
    }
}

