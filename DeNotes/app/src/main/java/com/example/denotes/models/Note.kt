package com.example.denotes.models

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val date: String = getCurrentDate() // automatically get and save the current date
)

//Function get current date
fun getCurrentDate(): String{
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return sdf.format(Date()) // get the current date and format it
}