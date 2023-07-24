package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.Screens.Screens

@Composable
fun MenuScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.Boton1.route) }) {
            Text(text = "Escribir una pregunta")
        }
        Button(onClick = { navController.navigate(route = Screens.Boton2.route) }) {
            Text(text = "Leer mis preguntas")
        }
        Button(onClick = { navController.navigate(route = Screens.Boton3.route) }) {
            Text(text = "Opciones")
        }
    }

}