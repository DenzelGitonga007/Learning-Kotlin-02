package com.example.denotes.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.denotes.data.database.NoteDatabase
import com.example.denotes.data.models.Note
import com.example.denotes.data.repository.NoteRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

// ViewModel to handle UI logic and interact with Room Database
class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository
    val allNotes: Flow<List<Note>> // Live list of notes

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        allNotes = repository.allNotes
    }

    // Function to add a new note
    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    // Function to delete a note
    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }
}
