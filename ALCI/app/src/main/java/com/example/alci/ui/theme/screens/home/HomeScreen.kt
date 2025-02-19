package com.example.alci.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alci.R
import com.example.alci.ui.theme.ALCITheme
import com.example.alci.ui.theme.Alci_Blue
import com.example.alci.ui.theme.screens.common.MyTopBar




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { MyTopBar(title = "Abundant Life Church ") },
        content = {  paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize() // fill the maximum screen size
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()), // scrolling
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                The logo first
                Image(
                    painter = painterResource(R.drawable.abundant_logo),
                    contentDescription = "Welcome Logo",
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth(0.8f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(24.dp))
//                Text
                Text(
                    text = "Welcome to Abundant Life Church",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700)
                )

                Spacer(modifier = Modifier.height(24.dp))

//                About us button
                Button(
                    onClick = {
                        navController.navigate("about")
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Alci_Blue)
                ) {
                    Text("About Us")
                }

                Spacer(modifier = Modifier.height(16.dp))

//                Our services
                Button(
                    onClick = {
                        navController.navigate("services")
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Alci_Blue)
                ) {
                    Text("Our Services")
                }

                Spacer(modifier = Modifier.height(16.dp))
//                Contact us
                Button(
                    onClick = {
                        navController.navigate("contact")
                    },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Alci_Blue)
                ) {
                    Text("Contact Us")
                }

            }
//            Bottom content
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


//The preview
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    ALCITheme {
        HomeScreen(navController = rememberNavController())
    }
}