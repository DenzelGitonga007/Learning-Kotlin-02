package com.example.alci.ui.theme.screens.our_services

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.alci.ui.theme.ALCITheme
import com.example.alci.ui.theme.screens.common.MyTopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ServicesScreen(navController: NavController){
    Scaffold(
        topBar = { MyTopBar(title = "Our Services") },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
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
                        At Abundant Life Church, we are committed to nurturing spiritual growth and serving our community through various ministries and programs. Our services are designed to uplift, inspire, and empower believers in their faith journey. These include:
                    
                        1. Sunday Worship Services  
                        Join us every Sunday for powerful worship, biblical teaching, and a time of fellowship. Our services are centered on the Word of God, helping you grow spiritually and experience His presence.
                    
                        2. Midweek Prayer and Bible Study  
                        Strengthen your faith through our interactive midweek Bible study and prayer meetings. These sessions provide an opportunity to dive deeper into Scripture and seek God’s guidance together as a community.
                    
                        3. Youth Fellowship  
                        Our dynamic youth ministry empowers young believers to grow in their faith, discover their purpose, and make a difference in their generation. Through mentorship, discussions, and activities, we nurture strong Christian values in young people.
                    
                        4. Children’s Ministry  
                        We believe in raising godly children by teaching them biblical truths in an engaging and fun environment. Our children’s ministry helps kids understand God’s love through Bible stories, worship, and interactive lessons.
                    
                        5. Family and Marriage Ministry  
                        Building strong families is at the heart of our ministry. We offer biblical counseling, workshops, and guidance to help couples and families grow in love, unity, and faith.
                    
                        6. Community Outreach Programs  
                        As a church, we are called to serve. Our outreach initiatives include supporting the needy, visiting the sick, and engaging in community development projects that reflect God’s love in action.
                    
                        7. Leadership and Discipleship Training  
                        We equip believers with the knowledge and skills needed to grow as disciples of Christ and become effective leaders in their families, workplaces, and ministries.
                    
                        8. Special Services and Events  
                        Throughout the year, we host revival meetings, worship nights, conferences, and other special events to strengthen the faith of our congregation and bring people closer to God.
                    
                        We welcome you to be part of these life-transforming services as we grow together in Christ and serve our community with love.
                    """.trimIndent(),
                    fontSize = 16.sp,
                    color = Color.Black,
                    lineHeight = 24.sp

                )
            }
            
        }
    ) // {  }

}


@Composable
@Preview(showBackground = true)
fun ServicesScreenPreview() {
    ALCITheme {
        ServicesScreen(navController = rememberNavController())
    }
}