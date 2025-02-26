package com.denzel.denotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.denzel.denotes.ui.theme.screens.AddNoteScreen
//import com.example.denotes.ui.theme.screens.AddNoteScreen
import com.denzel.denotes.ui.theme.screens.EditNoteScreen
import com.denzel.denotes.ui.theme.screens.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUTE_HOME
){

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){
//        The screens
//        Home screen
        composable(ROUTE_HOME){
            HomeScreen(navController = navController)
        }

//        Add note screen
        composable(ROUTE_ADD_NOTE) {
            AddNoteScreen(navController = navController)
        }

//        Edit note screen
        composable("edit_note/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull() ?: return@composable
            EditNoteScreen(navController, noteId)
        }






    }
}