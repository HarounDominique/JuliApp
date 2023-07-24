package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EscribirPregunta(){

    val vm : ViewModel = viewModel()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "PREGUNTA:")
        //TextField(value = , onValueChange = )
    }
}