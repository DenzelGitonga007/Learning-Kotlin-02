package com.denzel.denotes.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

//Define a table in the room db called "notes"
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
//    val color: Long // Ensure it matches the migration type
)


//Function get current date
//fun getCurrentDate(): String{
//    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
//    return sdf.format(Date()) // get the current date and format it
//}