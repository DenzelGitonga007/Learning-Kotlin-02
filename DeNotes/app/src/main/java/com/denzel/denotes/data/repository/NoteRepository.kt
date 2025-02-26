package com.denzel.denotes.data.repository

import com.denzel.denotes.data.dao.NoteDao
import com.denzel.denotes.data.models.Note
import kotlinx.coroutines.flow.Flow

// Repository to abstract data access from ViewModel
class NoteRepository(private val noteDao: NoteDao) {

    // Get all notes from the database
    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    // Insert a new note
    suspend fun insert(note: Note) {
        noteDao.insertNote(note)
    }

    // Delete an existing note
    suspend fun delete(note: Note) {
        noteDao.deleteNote(note)
    }
}
