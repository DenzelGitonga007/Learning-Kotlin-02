package com.denzel.denotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.denzel.denotes.navigation.AppNavHost
import com.denzel.denotes.ui.theme.DeNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeNotesTheme {
//                Call the AppNavHost
                AppNavHost()
            }
        }
    }
}
