package com.example.sanctuaryoflove


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge // Enables edge-to-edge rendering for modern UI
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme // Using Material 3 for UI styling
import androidx.compose.material3.Scaffold // Scaffold for structured layouts
import androidx.compose.material3.Surface // Surface for background and UI structure
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview // For previewing composables in Android Studio
import com.example.sanctuaryoflove.navigation.AppNavHost
import com.example.sanctuaryoflove.ui.theme.SanctuaryOfLoveTheme
import com.example.sanctuaryoflove.ui.theme.screens.home.HomeScreen


// MainActivity is the entry point of your app
class MainActivity : ComponentActivity() {
    // onCreate is called when the activity is launched
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enables edge-to-edge rendering, making the app utilize full screen space
        enableEdgeToEdge()

        // Defines the UI content using Jetpack Compose
        setContent {
            // Sets the app theme for consistent styling
            SanctuaryOfLoveTheme {
                // Surface provides a container with background styling
//                Surface(color = MaterialTheme.colorScheme.background) {
//                    // Calls the composable function to display the welcome screen content
//                    HomeScreen()
//                }

                // Call the navigation graph
                AppNavHost()
            }
        }
    }
}
