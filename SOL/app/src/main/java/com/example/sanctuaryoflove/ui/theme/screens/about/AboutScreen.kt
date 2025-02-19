package com.example.sanctuaryoflove.ui.theme.screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sanctuaryoflove.ui.theme.SanctuaryOfLoveTheme
import com.example.sanctuaryoflove.ui.theme.screens.common.MyTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = { MyTopAppBar(title = "About Us", navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start, // content to start from the margin
                verticalArrangement = Arrangement.Top // content to start from the top
            ) {
                Text(
                    text = "About Us",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(top = 16.dp)) // space from the top
                Text(
                    text = """
                        Sanctuary of Love Worship Centre is a vibrant, spirit-filled church located in Dandora Phase 4, Nairobi. Under the dedicated leadership of Bishop Boniface Wambua and Overseer Purity Mutwiwa, the church has become a beacon of hope and love for the community.
                        
                        At Sanctuary of Love Worship Centre, we are committed to fostering a deep relationship with God through worship, teaching, and fellowship. Our mission is to transform lives, empower believers, and spread the Gospel of Jesus Christ to all nations.
                        
                        We warmly welcome everyone to join our services, where you will experience heartfelt worship, powerful messages, and a loving community that seeks to live out the teachings of Christ in everyday life. Whether you are looking for spiritual growth, a place to belong, or a deeper connection with God, Sanctuary of Love is a place you can call home.
                        
                        Visit us at Dandora Phase 4 and become part of a family that worships together, grows together, and serves together for the glory of God.
                    """.trimIndent(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    lineHeight = 24.sp
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun AboutScreenPreview() {
    SanctuaryOfLoveTheme {
        AboutScreen(navController = rememberNavController())
    }
}
