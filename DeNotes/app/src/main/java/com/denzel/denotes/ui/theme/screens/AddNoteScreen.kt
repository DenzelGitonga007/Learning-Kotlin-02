package com.denzel.denotes.ui.theme.screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.denzel.denotes.navigation.ROUTE_HOME
import com.denzel.denotes.ui.theme.common.CommonScaffold
import com.denzel.denotes.data.models.Note
//import com.example.denotes.navigation.ROUTE_HOME
import com.denzel.denotes.ui.theme.DeNotesTheme
//import com.denzel.denotes.ui.viewmodel.NoteViewModel
import com.denzel.denotes.data.viewmodel.NoteViewModel


@Composable
fun AddNoteScreen(navController: NavHostController, viewModel: NoteViewModel = viewModel()) {
    var title: String by remember { mutableStateOf("") }
    var content: String by remember { mutableStateOf("") }
//    var selectedColor: Color by remember { mutableStateOf(defaultColors.first()) }

    CommonScaffold(
        title = "New Note",
        navController = navController
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

//            Title input
            Text(text = "Title", fontSize = 24.sp)
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("Title of the note") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))

//            Content input
            Text(text = "Content", fontSize = 24.sp)
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                placeholder = { Text("Write your note here") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Default),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp).padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Color Picker Dropdown
//            Text(text = "Select Note Color", fontSize = 20.sp)
//            ColorDropdown(selectedColor) { selectedColor = it }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (title.isNotBlank() && content.isNotBlank()) {
                        val newNote = Note(
                            title = title,
                            content = content,
//                            color = selectedColor.value.toLong() // Store color as Long
                        )
                        viewModel.insert(newNote)
                        navController.navigate(ROUTE_HOME)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = title.isNotBlank() && content.isNotBlank()
            ) {
                Text("Add Note", fontSize = 22.sp)
            }
        }
    }
}

// Color name mapping
val colorNames = mapOf(
    Color.Red to "Red",
    Color(0xFFFF7F00) to "Orange",
    Color.Yellow to "Yellow",
    Color.Green to "Green",
    Color.Blue to "Blue",
    Color(0xFF4B0082) to "Indigo"
)


//Color dropdown
//@Composable
//fun ColorDropdown(selectedColor: Color, onColorSelected: (Color) -> Unit) {
//    var expanded by remember { mutableStateOf(false) }
//
//    Box {
//        Button(onClick = { expanded = true }) {
//            Text("Pick Color: ${colorNames[selectedColor] ?: "Unknown"}")
//        }
//
//        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//            defaultColors.forEach { color ->
//                DropdownMenuItem(
//                    text = { Text(colorNames[color] ?: "Unknown", color = Color.White) },
//                    onClick = {
//                        onColorSelected(color)
//                        expanded = false
//                    },
//                    modifier = Modifier.background(color)
//                )
//            }
//        }
//    }
//}


// Color(0xFFFF7F00)// Orange
// Color(0xFF4B0082), // Indigo

//// List of predefined colors
//val defaultColors = listOf(
//    Color.Red, Color(0xFFFF7F00), Color.Yellow, Color.Green, Color.Blue, Color(0xFF4B0082), // Indigo, Color.Violet
//)



// Preview function for testing UI
@Composable
@Preview(showBackground = true)
fun AddNoteScreenPreview() {
    DeNotesTheme {
        AddNoteScreen(navController = rememberNavController())
    }
}
