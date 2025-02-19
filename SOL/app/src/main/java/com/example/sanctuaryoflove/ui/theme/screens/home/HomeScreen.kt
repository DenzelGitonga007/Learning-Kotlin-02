package com.example.sanctuaryoflove.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sanctuaryoflove.R
import com.example.sanctuaryoflove.ui.theme.SanctuaryOfLoveTheme
import com.example.sanctuaryoflove.ui.theme.Sol_Blue
import com.example.sanctuaryoflove.ui.theme.screens.common.MyTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // Scaffold provides structure for the top bar and content
    Scaffold(
        topBar = { MyTopAppBar(title = "Sanctuary of Love", navController) },
        content = { paddingValues ->
            // Ensure content does not overlap the top bar
            Column(
                modifier = Modifier
                    .fillMaxSize() // Make sure content fills the entire screen
                    .background(Color.White) // Set background color to white
                    .padding(paddingValues) // Add padding from Scaffold
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Welcome Image",
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth(0.8f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Welcome Text
                Text(
                    text = "Welcome to Sanctuary of Love Worship Centre",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Button for About Us
                Button(
                    onClick = {
                        navController.navigate("about") // set the button to go the about screen
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Sol_Blue)
                ) {
                    Text("About Us")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Button for Our Services
                Button(
                    onClick = {
                        navController.navigate("services") // go to our services screen
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Sol_Blue)
                ) {
                    Text("Our Services")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Button for Contact Us
                Button(
                    onClick = {
                        navController.navigate("contact") // go to contact
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Sol_Blue)
                ) {
                    Text("Contact Us")
                }
            }


//            Bottom Content
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom

            ) {
                Text(
                    text = """
                        App developed with ❤ by Tech with Denzel
                        0714082283
                        denzelgitonga001@gmail.com
                        
                        
                    """.trimIndent(),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    SanctuaryOfLoveTheme {
        HomeScreen(navController = rememberNavController())
    }
}
