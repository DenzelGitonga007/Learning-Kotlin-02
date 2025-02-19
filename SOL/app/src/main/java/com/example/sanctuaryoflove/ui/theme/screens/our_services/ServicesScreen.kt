package com.example.sanctuaryoflove.ui.theme.screens.our_services

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")



@Composable
fun ServicesScreen(navController: NavController) {
    Scaffold(
        topBar = { MyTopAppBar(title = "Our Services", navController) },
        content = {  paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()), // enable vertical scrolling
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Our Services",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Text(
                    text = """
        
        At Sanctuary of Love Worship Centre, we are committed to providing a wide range of spiritual and community-focused services to meet the needs of our congregation and the broader community. These include:

        1. Sunday Worship Services  
        Experience the presence of God through spirit-filled worship, powerful preaching, and uplifting fellowship every Sunday. Our services are designed to inspire, encourage, and help you grow in your faith.

        2. Midweek Bible Study and Prayer Meetings  
        Dive deeper into God’s Word and strengthen your relationship with Him through our interactive Bible study sessions. Join us for prayer meetings as we seek God’s guidance, strength, and blessings for our lives and community.

        3. Youth Ministry  
        Our vibrant youth ministry focuses on empowering young people with the Word of God, equipping them to be strong in their faith and impactful in their communities. Through mentorship, engaging activities, and relevant teaching, we aim to raise a generation that honors God.

        4. Children's Ministry  
        We believe in planting seeds of faith in our children from an early age. Our children’s ministry offers a fun and nurturing environment where kids can learn about God through Bible stories, songs, and interactive lessons.

        5. Marriage and Family Counseling  
        Strengthening families is a key focus at Sanctuary of Love. We offer biblical guidance and counseling to couples and families to help them build stronger, Christ-centered relationships.

        6. Community Outreach Programs  
        As part of our mission to serve others, we engage in various outreach initiatives, including food distribution, educational support, and other acts of kindness to uplift the less fortunate in our community.

        7. Discipleship and Leadership Training  
        We are dedicated to equipping believers with the knowledge and skills they need to grow as disciples of Christ and lead effectively in their spheres of influence.

        8. Special Services and Events  
        From revival meetings and conferences to worship nights and celebrations, we host special events throughout the year to enrich and uplift the spiritual lives of our congregation.
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
fun ServicesScreenPreview(){
    SanctuaryOfLoveTheme {
        ServicesScreen(navController = rememberNavController())
    }
}