package com.example.denotes.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.denotes.models.Note
import com.example.denotes.navigation.ROUTE_HOME
import com.example.denotes.ui.theme.DeNotesTheme
import com.example.denotes.ui.theme.common.CommonScaffold
import java.util.*

@Composable
fun AddNoteScreen(navController: NavHostController) {

    // Declare mutable states for title and content
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    // Use the common scaffold
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
            // Title label
            Text(
                text = "Title",
                fontSize = 24.sp,
                )

            // The text input field for title
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text(text="Title of the note") },
//                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
//                textStyle = TextStyle.Default,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),

//                label = { Text(text="Title") }
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Content label
            Text(
                text = "Content",
                fontSize = 24.sp,
                )

            // Text field for entering note content
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                placeholder = { Text(text = "Write your note here") },
//                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions { /* Hide Keyboard */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Save button
            Button(
                onClick = {
                    if (title.isNotBlank() && content.isNotBlank()) {
                        val newNote = Note(
                            id = UUID.randomUUID().toString(), // Generate a proper UUID
                            title = title,
                            content = content
                        )
                        // TODO: Save the note to the database or state management
                        navController.navigate(ROUTE_HOME) // Navigate back to home after saving
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = title.isNotBlank() && content.isNotBlank()
            ) {
                Text("Save Note")
            }
        }
    }
}




// Preview function for testing UI
@Composable
@Preview(showBackground = true)
fun AddNoteScreenPreview() {
    DeNotesTheme {
        AddNoteScreen(navController = rememberNavController())
    }
}
