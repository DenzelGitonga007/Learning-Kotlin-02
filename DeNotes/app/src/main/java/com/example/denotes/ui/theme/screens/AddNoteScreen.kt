package com.example.denotes.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.denotes.ui.theme.DeNotesTheme
import com.example.denotes.ui.theme.common.CommonScaffold

@Composable
fun AddNoteScreen(navController: NavHostController) {

//    Declare the variables to be stored
    val title by remember { mutableStateOf("") } // title
    val content by remember { mutableStateOf("") } // content

//    Use the common scaffold
    CommonScaffold(
        title = "New Note", // title of the screen
        navController = navController // pass the nav controller
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize() // column to fill the maximum screen size
                .padding(padding) // apply padding from the scaffold
                .padding(16.dp) // extra spacing
        ) {
            // Title label
            Text(text = "Title")
//            The text input field




        }

    }

}




@Composable
@Preview(showBackground = true)
fun AddNoteScreenPreview(){
    DeNotesTheme{
        AddNoteScreen(navController = rememberNavController())
    }
}