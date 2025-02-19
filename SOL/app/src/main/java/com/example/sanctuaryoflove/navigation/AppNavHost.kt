package com.example.sanctuaryoflove.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sanctuaryoflove.ui.theme.screens.about.AboutScreen
import com.example.sanctuaryoflove.ui.theme.screens.contact.ContactScreen
import com.example.sanctuaryoflove.ui.theme.screens.home.HomeScreen
import com.example.sanctuaryoflove.ui.theme.screens.our_services.ServicesScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUTE_HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

//        Define the screens as by their routes
//        Home Route
        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }
//        About Route
        composable(ROUTE_ABOUT) {
            AboutScreen(navController = navController)
        }

//        Services Route
        composable(ROUTE_SERVICES) {
            ServicesScreen(navController = navController)
        }

//        Contact Route
        composable(ROUTE_CONTACT) {
            ContactScreen(navController = navController)
        }




    }
}