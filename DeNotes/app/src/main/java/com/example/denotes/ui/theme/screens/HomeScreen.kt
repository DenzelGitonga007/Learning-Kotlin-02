package com.example.denotes.ui.theme.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.denotes.ui.theme.DeNotesTheme
import com.example.denotes.ui.theme.common.CommonScaffold

@Composable
fun HomeScreen(navController: NavHostController) {
    CommonScaffold(
        title = "DeNotes", // Title for Top Bar
        navController = navController // Navigation Controller
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp) // Add spacing
        ) {
            Text(text = "Welcome to DeNotes!")
        }
    }
}



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    DeNotesTheme {
        HomeScreen(navController = rememberNavController())
    }
}