package com.example.denotes.ui.theme.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.denotes.navigation.ROUTE_HOME
import com.example.denotes.navigation.ROUTE_EDIT_NOTE
import com.example.denotes.ui.theme.DeNotes_Theme
import com.example.denotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonScaffold(
    title: String,
    navController: NavHostController,
    floatingActionButton: @Composable (() -> Unit)? = null, // floating action button is optional
    deleteNoteAction: (() -> Unit)? = null, // Accept delete function
    content: @Composable (PaddingValues) -> Unit
) {
    var currentRoute by remember { mutableStateOf(ROUTE_HOME) }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            val fullRoute = backStackEntry.destination.route ?: ROUTE_HOME
            currentRoute = backStackEntry.arguments?.getString("noteId")?.let { "edit/$it" } ?: fullRoute
            println("Current Route Updated: $currentRoute") // Debugging
        }
    }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.denotes),
                            contentDescription = "Logo",
                            modifier = Modifier.size(34.dp).clip(RoundedCornerShape(8.dp))
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(title, color = Color.White)
                    }
                },
                navigationIcon = {
                    if (currentRoute != ROUTE_HOME) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DeNotes_Theme)
            )
        },
        bottomBar = {
            if (currentRoute != ROUTE_HOME) {
                BottomAppBar(containerColor = DeNotes_Theme, contentColor = Color.White) {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }) {
                        Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White)
                    }

                    Spacer(modifier = Modifier.weight(0.5f)) // Push delete button to the right

                    if (currentRoute.startsWith("edit/")) {
                        println("Showing delete button") // Debugging
                        IconButton(onClick = {
                            deleteNoteAction?.invoke()
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Delete Note", tint = Color.White)
                        }
                    }



                }
            }
        },
        floatingActionButton = floatingActionButton ?: {} // Provide an empty lambda when null
    ) { innerPadding ->
        content(innerPadding)
    }
}
