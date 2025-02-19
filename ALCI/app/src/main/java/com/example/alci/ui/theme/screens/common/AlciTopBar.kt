package com.example.alci.ui.theme.screens.common

import android.icu.text.CaseMap.Title
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.alci.R
import com.example.alci.ui.theme.Alci_Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(title: String) {
    TopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
//                The logo
                Image(
                    painter = painterResource(id = R.drawable.abundant_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(34.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
//                Space
                Spacer(modifier = Modifier.width(10.dp))
//                App title
                Text(title, color = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Alci_Blue)

    )
}