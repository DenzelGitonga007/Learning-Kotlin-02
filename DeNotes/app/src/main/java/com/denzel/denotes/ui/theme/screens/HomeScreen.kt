package com.denzel.denotes.ui.theme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import com.denzel.denotes.navigation.ROUTE_ADD_NOTE
import com.denzel.denotes.ui.theme.common.CommonScaffold
//import com.denzel.denotes.ui.viewmodel.NoteViewModel
import androidx.compose.foundation.combinedClickable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import com.denzel.denotes.data.models.Note
//import com.denzel.denotes.data.models.Note
import com.denzel.denotes.data.viewmodel.NoteViewModel
import com.denzel.denotes.ui.theme.Brown80
import com.denzel.denotes.ui.theme.DeNotes_Theme
import com.denzel.denotes.ui.theme.OrangeBrown40


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: NoteViewModel = viewModel()) {
    val notes by viewModel.allNotes.collectAsState(initial = emptyList())

    // Track selected note for long press actions
    var selectedNote by remember { mutableStateOf<Note?>(null) }
    var showOptionsDialog by remember { mutableStateOf(false) }

    CommonScaffold(
        title = "DeNotes",
        navController = navController,
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(ROUTE_ADD_NOTE) }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
//                .background(OrangeBrown40)
                .background(Brown80)
                .padding(8.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notes) { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .combinedClickable(
                            onClick = {
                                navController.navigate("edit_note/${note.id}") // Normal tap = Edit
                            },
                            onLongClick = {
                                selectedNote = note
                                showOptionsDialog = true
                            }
                        ),
                    colors = CardDefaults.cardColors(containerColor = getColor(notes.indexOf(note)))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = note.title, fontSize = 24.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = note.content, fontSize = 16.sp)
                    }
                }
            }
        }
    }

    // Show the dialog when a note is long-pressed
    if (showOptionsDialog && selectedNote != null) {
        AlertDialog(
            onDismissRequest = { showOptionsDialog = false },
            title = { Text("Note Options") },
            text = { Text("What do you want to do with this note?") },
            confirmButton = {
                TextButton(onClick = {
                    navController.navigate("edit_note/${selectedNote!!.id}")
                    showOptionsDialog = false
                }) {
                    Text("Edit", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    viewModel.delete(selectedNote!!)
                    showOptionsDialog = false
                }) {
                    Text("Delete", color = Color.White)
                }
            }
        )
    }
}




// Function to cycle through predefined colors for notes
fun getColor(index: Int): Color {
//    val colors = listOf(
//        Color(0xFFE12162), // Change this to pink
//        Color(0xFF20B2AA), // Light Sea Green
//        Color(0xFFCCAF14), // Gold
//        Color(0xFF6495ED), // Cornflower Blue



//    )
    val colors = listOf(
        Color(0xFFDC143C), // Crimson
        Color(0xFF32CD32), // Lime Green
        Color(0xFF8A2BE2),  // Blue Violet
        Color(0xFFFFA07A), // Light Salmon (Warm & Soft)
        Color(0xFF7B68EE), // Medium Slate Blue (Vibrant & Deep)
        Color(0xFF00CED1), // Dark Turquoise (Refreshing & Bold)
        Color(0xFFFFD700), // Gold (Bright & Luxurious)
        Color(0xFF48D1CC), // Medium Turquoise (Calm & Modern)
        Color(0xFFEE82EE), // Violet (Playful & Elegant)
        Color(0xFF3CB371), // Medium Sea Green (Lush & Natural)
        Color(0xFFFF6347), // Tomato (Bold & Energizing)
        Color(0xFF4682B4), // Steel Blue (Sophisticated & Cool)
        Color(0xFFF08080)  // Light Coral (Soft & Warm)
    )

    return colors[index % colors.size]
}

// Preview function to see HomeScreen in Android Studio
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
