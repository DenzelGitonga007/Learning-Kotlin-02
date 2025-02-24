package com.example.denotes.ui.theme.screens.home

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
import com.example.denotes.ui.theme.common.CommonScaffold
import com.example.denotes.ui.viewmodel.NoteViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: NoteViewModel = viewModel()) {
    val notes by viewModel.allNotes.collectAsState(initial = emptyList())

    CommonScaffold(
        title = "DeNotes",
        navController = navController,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(ROUTE_ADD_NOTE)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2), // 2 columns staggered
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(8.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notes) { note ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = getColor(notes.indexOf(note)))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = note.title, fontSize = 24.sp) // title
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = note.content, fontSize = 16.sp) // content
                    }
                }
            }
        }
    }
}

// Function to cycle through colors
fun getColor(index: Int): Color {
    val colors = listOf(
        Color(0xFFFFA07A), // Light Salmon
        Color(0xFF20B2AA), // Light Sea Green
        Color(0xFFFFD700), // Gold
        Color(0xFF6495ED), // Cornflower Blue
        Color(0xFFDC143C), // Crimson
        Color(0xFF32CD32), // Lime Green
        Color(0xFF8A2BE2)  // Blue Violet
    )
    return colors[index % colors.size]
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
