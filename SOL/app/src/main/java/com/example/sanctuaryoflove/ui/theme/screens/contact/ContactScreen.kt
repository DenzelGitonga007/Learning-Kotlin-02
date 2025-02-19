package com.example.sanctuaryoflove.ui.theme.screens.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sanctuaryoflove.R
import com.example.sanctuaryoflove.ui.theme.SanctuaryOfLoveTheme
import com.example.sanctuaryoflove.ui.theme.screens.common.MyTopAppBar

@Composable
fun ContactScreen(navController: NavController){
    Scaffold(
        topBar = { MyTopAppBar(title = "Contact Us", navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
            ) {
                // Bishop Boniface
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.bishop_boniface),
                        contentDescription = "Bishop Boniface's photo",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(50.dp))

                        )

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(
                        """
                            Bishop Boniface Wambua
                            
                            0722989616
                        """.trimIndent(),
                        fontSize = 20.sp,
                        color = Color.Black,
                        lineHeight = 18.sp,

                    )

                }
                Spacer(modifier = Modifier.height(25.dp))

//                Overseer Purity
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.overseer_purity),
                        contentDescription = "Overseer Purity",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(
                        """
                            Overseer Purity Mutwiwa
                            
                            0722449055
                        """.trimIndent(),
                        fontSize = 20.sp,
                        color = Color.Black,
                        lineHeight = 18.sp

                    )
                }
            }

        }
    )
}



@Composable
@Preview(showBackground = true)
fun ContactScreenPreview(){
    SanctuaryOfLoveTheme {
        ContactScreen(navController = rememberNavController())
    }
}