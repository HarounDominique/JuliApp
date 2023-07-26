package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel

@Composable
fun LeerPregunta(){

    val vm : JuliViewModel = viewModel()

    val questionEntries = vm.listOfQuestions;

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        questionEntries.forEach { entry ->
            Button(onClick = {
                // Acción cuando se hace clic en el botón
                // Por ejemplo, puedes mostrar el texto de la entrada en la consola
                println("Se hizo clic en el botón de $entry")
            }) {
                Text(text = "entry", style = TextStyle(fontSize = 20.sp))
            }
        }
    }

}