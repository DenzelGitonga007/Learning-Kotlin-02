package com.example.alci.navigation

import android.graphics.pdf.content.PdfPageGotoLinkContent.Destination
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alci.ui.theme.screens.about.AboutScreen
import com.example.alci.ui.theme.screens.contact.ContactScreen
import com.example.alci.ui.theme.screens.home.HomeScreen
import com.example.alci.ui.theme.screens.our_services.ServicesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME

) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
//        Define the screens
//        HomeScreen
        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }

//        About screen
        composable(ROUTE_ABOUT) {
            AboutScreen(navController = navController)
        }

//        Contact us screen
        composable(ROUTE_CONTACT) {
            ContactScreen(navController = navController)
        }

//        Services screen
        composable(ROUTE_SERVICES) {
            ServicesScreen(navController = navController)
        }
    }


}