package com.example.denotes.ui.theme.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.denotes.navigation.ROUTE_ADD_NOTE
import com.example.denotes.navigation.ROUTE_EDIT_NOTE
import com.example.denotes.ui.theme.common.CommonScaffold
import com.example.denotes.ui.viewmodel.NoteViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: NoteViewModel = viewModel()) {
    // Collect all notes from the ViewModel (Live data flow)
    val notes by viewModel.allNotes.collectAsState(initial = emptyList())

    // Using a common scaffold layout
    CommonScaffold(
        title = "DeNotes",
        navController = navController,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(ROUTE_ADD_NOTE) // Navigate to the Add Note screen
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        // Display notes in a staggered grid format
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2), // Set a 2-column layout
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(8.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Iterate through each note and display it inside a card
            items(notes) { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // Navigate to the EditNoteScreen when a note is clicked
                            navController.navigate("edit_note/${note.id}")
//                            navController.navigate(ROUTE_EDIT_NOTE)
                        },
                    colors = CardDefaults.cardColors(containerColor = getColor(notes.indexOf(note)))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = note.title, fontSize = 24.sp) // Display note title
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = note.content, fontSize = 16.sp) // Display note content
                    }
                }
            }
        }
    }
}

// Function to cycle through predefined colors for notes
fun getColor(index: Int): Color {
    val colors = listOf(
        Color(0xFFE12162), // Change this to pink
        Color(0xFF20B2AA), // Light Sea Green
        Color(0xFFCCAF14), // Gold
        Color(0xFF6495ED), // Cornflower Blue
        Color(0xFFDC143C), // Crimson
        Color(0xFF32CD32), // Lime Green
        Color(0xFF8A2BE2)  // Blue Violet
    )
    return colors[index % colors.size]
}

// Preview function to see HomeScreen in Android Studio
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
