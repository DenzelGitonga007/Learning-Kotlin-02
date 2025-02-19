package com.example.d_eats.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.d_eats.R
import com.example.d_eats.navigation.ADD_MENU
import com.example.d_eats.ui.theme.LightCyan

// Suppress warning for unused scaffold padding
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // Scaffold provides a structure for the screen with top bar, bottom bar, floating buttons, etc.
    Scaffold(
        // Top bar of the screen
        topBar = {
            TopAppBar(
                title = {
                    // Title of the app
                    Text(
                        text = "D-Eats",
                        fontSize = 40.sp, // Font size in sp (scale-independent pixels)
                        fontFamily = FontFamily.Cursive, // Cursive font style
                        fontWeight = FontWeight.ExtraBold // Extra bold text
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LightCyan, // Background color of the TopAppBar
                    titleContentColor = Color.White // Title text color
                )
            )
        },
        // Floating action button at the bottom-right of the screen
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(ADD_MENU)
                },
                containerColor = LightCyan // Button background color
            ) {
                // Add icon inside the floating action button
                Icon(Icons.Default.Add, contentDescription = "Add Meal", tint = Color.White)
            }
        },
        // Main content area
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize() // Take up the entire screen
                    .padding(padding), // Padding to avoid overlap with other components
                horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
            ) {
                // Welcome message
                Text(
                    text = "Welcome to D-Eats!",
                    fontSize = 18.sp, // Font size
                    modifier = Modifier.padding(top = 16.dp) // Padding from the top
                )

                Spacer(modifier = Modifier.height(10.dp)) // Spacer for spacing between elements

                // LazyColumn to display a scrollable list of meal cards
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth() // List takes the full width of the screen
                        .padding(horizontal = 14.dp) // Padding on the sides
                ) {
                    // Generate a list of 10 meal cards
                    items(10) { index ->
                        MealCard(
                            name = "Meal $index", // Meal name
                            description = "Delicious Meal $index", // Meal description
                            price = "$${10 + index}", // Meal price
                            onEdit = { /* Handle edit logic */ }, // Edit action
                            onDelete = { /* Handle delete logic */ } // Delete action
                        )
                    }
                }
            }
        }
    )
}

// Composable function for each individual meal card
@Composable
fun MealCard(name: String, description: String, price: String, onEdit: () -> Unit, onDelete: () -> Unit) {
    // Card with a light grey background
    Card(
        modifier = Modifier
            .fillMaxWidth() // Card takes the full width of the screen
            .padding(vertical = 5.dp), // Padding between cards
        shape = RoundedCornerShape(5.dp), // Rounded corners with a radius of 5.dp
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Shadow under the card
    ) {
        // Row to arrange items horizontally
        Row(
            modifier = Modifier
                .fillMaxWidth() // Row takes the full width of the card
                .padding(16.dp), // Padding inside the card
            verticalAlignment = Alignment.CenterVertically // Center items vertically
        ) {
            // Placeholder image for the meal
            Image(
                painter = painterResource(R.drawable.register), // Replace with actual meal image
                contentDescription = "Meal Image", // Accessibility description
                modifier = Modifier
                    .size(64.dp) // Image size
                    .padding(end = 16.dp) // Padding between image and text
                    .background(Color.White, shape = RoundedCornerShape(8.dp)) // Background with rounded corners
            )
            // Column for meal details
            Column(
                modifier = Modifier.weight(1f) // Take up remaining space
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                ) // Meal name
                Text(
                    text = description,
                    fontSize = 14.sp,
                    maxLines = 1,
                    color = Color.Black
                ) // Meal description (1 line)
                Text(
                    text = price,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ) // Meal price
            }
            // Edit button
            IconButton(onClick = onEdit) {
                Icon(Icons.Default.Edit, contentDescription = "Edit Meal", tint = Color.Black)
            }
            // Delete button
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Delete Meal", tint = Color.Red)
            }
        }
    }
}

// Preview function to test the HomeScreen composable
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
