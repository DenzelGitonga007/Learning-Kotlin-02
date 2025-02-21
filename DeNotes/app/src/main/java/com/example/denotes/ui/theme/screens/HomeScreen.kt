package com.example.denotes.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import kotlin.random.Random

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(notes.size) { index ->
                    val backgroundColor = getRandomColor(index)
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(containerColor = backgroundColor)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = notes[index].title, fontSize = 20.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = notes[index].content, fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}

fun getRandomColor(index: Int): Color {
    val colors = listOf(
        Color(0xFFFFEB3B), // Yellow
        Color(0xFF8BC34A), // Green
        Color(0xFFFF5722), // Orange
        Color(0xFF03A9F4), // Blue
        Color(0xFF9C27B0)  // Purple
    )
    return colors[index % colors.size]
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
