package com.example.d_eats.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.d_eats.ui.theme.screens.Menu.AddMenuScreen
import com.example.d_eats.ui.theme.screens.Menu.ViewMenuScreen
import com.example.d_eats.ui.theme.screens.about.AboutScreen
import com.example.d_eats.ui.theme.screens.home.HomeScreen
import com.example.d_eats.ui.theme.screens.login.LoginScreen
import com.example.d_eats.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUTE_REGISTER
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUTE_ABOUT) {
            AboutScreen(navController = navController)
        }

        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController = navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(ADD_MENU){
            AddMenuScreen(navController = navController)
        }
        composable(VIEW_MENU){
            ViewMenuScreen(navController = navController)
        }



    }
}