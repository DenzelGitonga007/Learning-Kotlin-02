package com.example.denotes.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.denotes.data.models.Note
import com.example.denotes.ui.theme.DeNotes_Theme
import com.example.denotes.ui.theme.common.CommonScaffold
import com.example.denotes.ui.viewmodel.NoteViewModel

@Composable
fun EditNoteScreen(navController: NavHostController, noteId: Int, viewModel: NoteViewModel = viewModel()) {
    // Collect all notes from ViewModel
    val allNotes by viewModel.allNotes.collectAsState(initial = emptyList())

    // Find the note using the noteId passed from HomeScreen
    val note = allNotes.find { it.id.toInt() == noteId } ?: return // Exit if note is not found

    // Remember state for editing note fields
    var title by remember { mutableStateOf(note.title) }
    var content by remember { mutableStateOf(note.content) }

    // Use CommonScaffold for consistent UI
    CommonScaffold(
        title = "Edit Note",
        navController = navController,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Save the updated note to the database
                viewModel.insert(Note(id = note.id, title = title, content = content))
                navController.popBackStack() // Navigate back to HomeScreen after saving
            }) {
                Text("Save") // Floating save button
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            // Input field for note title
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
                label = { Text("Title") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Input field for note content
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                label = { Text("Content") }
            )
        }
    }
}





@Composable
@Preview(showBackground = true)
fun EditNoteScreenPreview(){
    EditNoteScreen(navController = rememberNavController(), noteId = 1)
}
