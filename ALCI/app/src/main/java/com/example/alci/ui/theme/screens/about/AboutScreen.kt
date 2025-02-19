package com.example.alci.ui.theme.screens.about

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun AboutScreen(navController: NavController){
    Scaffold(
        topBar = { MyTopBar(title = "About Us") },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "About Us",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(top = 20.dp)) // space from the top

                Text(
                    text = """
                            Abundant Life Church is a Christ-centered, spirit-filled community located in Kaimosi, Cheptulu, Vihiga County. Under the guidance of dedicated spiritual leaders, we are committed to sharing the love of Christ and nurturing a strong, faith-driven congregation.
                        
                            At Abundant Life Church, we believe in the power of worship, prayer, and biblical teaching to transform lives. Our mission is to bring hope, inspire faith, and build a community that reflects the love and grace of Jesus Christ.
                        
                            We invite you to join us for uplifting worship services, impactful Bible studies, and fellowship that strengthens your walk with God. Whether you are seeking spiritual growth, a supportive faith family, or a place to encounter God’s presence, Abundant Life Church welcomes you with open arms.
                        
                            Come and experience a church where faith comes alive, love is shared, and lives are transformed. Together, we grow, worship, and serve for the glory of God.
                        
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
fun AboutScreenPreview(){
    ALCITheme {
        AboutScreen(navController = rememberNavController())
    }
}