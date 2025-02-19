package com.example.sanctuaryoflove.ui.theme.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sanctuaryoflove.R
import com.example.sanctuaryoflove.ui.theme.Sol_Blue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String, navController: NavController) {


    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Add logo on the left
                Image(
                    painter = painterResource(id = R.drawable.logo), // logo drawable
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(32.dp) // Set the size of the image
                        .clip(RoundedCornerShape(8.dp)) // Clip the image to rounded corners
                )

                Spacer(modifier = Modifier.width(10.dp))
                // App title
                Text(title, color = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Sol_Blue) // Use the custom color
    )
}
