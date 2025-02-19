package com.example.denotes.ui.theme.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.denotes.navigation.ROUTE_HOME
import com.example.denotes.ui.theme.DeNotes_Theme
import com.example.denotes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonScaffold(
    title: String,
    navController: NavHostController,
    floatingActionButton: @Composable (() -> Unit)? = null, // ✅ Accept FAB as an optional parameter
    content: @Composable (PaddingValues) -> Unit
) {
    val currentRoute = navController.currentDestination?.route ?: ROUTE_HOME // Handle null case

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
                    NavigationBar(containerColor = DeNotes_Theme) {
                        val navItems = listOf(BottomNavItem("Home", ROUTE_HOME, Icons.Default.Home))
                        navItems.forEach { item ->
                            NavigationBarItem(
                                icon = { Icon(item.icon, contentDescription = item.label, tint = Color.White) },
                                label = { Text(item.label, color = Color.White) },
                                selected = currentRoute == item.route,
                                onClick = {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
                                }
                            )
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
