package com.example.denotes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.denotes.data.dao.NoteDao
import com.example.denotes.data.models.Note

// Defines the Room Database with Note as the only entity
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    // Returns an instance of NoteDao
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        // Singleton pattern to ensure we only create one instance of the database
        fun getDatabase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration() // This will reset the database if version changes
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
