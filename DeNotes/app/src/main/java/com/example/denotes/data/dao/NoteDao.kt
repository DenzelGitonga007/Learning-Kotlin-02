package com.example.denotes.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.denotes.data.models.Note
import kotlinx.coroutines.flow.Flow


//Create the data access object for the db operations
@Dao
interface NoteDao {
//    Insert a note into the db, and replace it if it exists
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)


//    Delete a specific note
    @Delete
    suspend fun deleteNote(note: Note)

//    Fetch all notes
    @Query("SELECT * FROM notes ORDER BY timestamp DESC")

    fun getAllNotes(): Flow<List<Note>> // returns  flow so UI updates in real-time


}