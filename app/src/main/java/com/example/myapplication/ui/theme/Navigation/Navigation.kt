package com.example.myapplication.ui.theme.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MenuScreen
import com.example.myapplication.ui.theme.Screens.EscribirPregunta
import com.example.myapplication.ui.theme.Screens.Screens

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) { MenuScreen(navController) }
        composable(route = Screens.Boton1.route) { EscribirPregunta() }
        composable(route = Screens.Boton2.route) { }
        composable(route = Screens.Boton3.route) { }
    }
}

