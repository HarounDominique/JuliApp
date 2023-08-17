package com.example.myapplication.ui.theme.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MenuScreen
import com.example.myapplication.ui.theme.Screens.EscribirPregunta
import com.example.myapplication.ui.theme.Screens.LeerPregunta
import com.example.myapplication.ui.theme.Screens.Screens
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val vm : JuliViewModel = viewModel()
    NavHost(navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) { MenuScreen(navController) }
        composable(route = Screens.Boton1.route) { EscribirPregunta(vm, navController) }
        composable(route = Screens.Boton2.route) { LeerPregunta(vm) }
    }
}

