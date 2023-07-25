package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Screens.Screens

@Composable
fun MenuScreen(navController: NavController) {

    val quicksandFont = FontFamily(Font(R.font.quicksand_regular))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Button(onClick = { navController.navigate(route = Screens.Boton1.route) }) {
            Text(text = "Escribir una pregunta",
                style = TextStyle(
                    fontFamily = quicksandFont,
                    fontSize = 30.sp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = { navController.navigate(route = Screens.Boton2.route) }) {
            Text(text = "Leer mis preguntas",
                style = TextStyle(
                    fontFamily = quicksandFont,
                    fontSize = 30.sp))
        }
        /*
        Button(onClick = { navController.navigate(route = Screens.Boton3.route) }) {
            Text(text = "Opciones")
        }
         */
    }

}