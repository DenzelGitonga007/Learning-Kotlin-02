package com.denzel.denotes.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.denzel.denotes.data.models.Note
import com.denzel.denotes.ui.theme.common.CommonScaffold
import com.denzel.denotes.data.viewmodel.NoteViewModel

@Composable
fun EditNoteScreen(navController: NavHostController, noteId: Int, viewModel: NoteViewModel = viewModel()) {
    val allNotes by viewModel.allNotes.collectAsState(initial = emptyList())
    val note = allNotes.find { it.id.toInt() == noteId } ?: return

    var title by remember { mutableStateOf(note.title) }
    var content by remember { mutableStateOf(note.content) }

    CommonScaffold(
        title = "Edit Note",
        navController = navController,
        deleteNoteAction = {
            viewModel.delete(note)
            navController.popBackStack()
        }


    )
     { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))

            Text(text = "Content", fontSize = 24.sp)

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Default),
                label = { Text("Content") },
                modifier = Modifier.fillMaxWidth().height(500.dp).padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = {
                    if (title.isNotBlank() && content.isNotBlank()) {
                        viewModel.insert(Note(id = note.id, title = title, content = content))
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = title.isNotBlank() && content.isNotBlank()
            ) {
                Text("Update Note", fontSize = 22.sp)
            }
        }
    }
}





@Composable
@Preview(showBackground = true)
fun EditNoteScreenPreview(){
    EditNoteScreen(navController = rememberNavController(), noteId = 1)
}
