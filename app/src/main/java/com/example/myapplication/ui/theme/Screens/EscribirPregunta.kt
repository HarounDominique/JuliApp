package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EscribirPregunta(){

    val vm : JuliViewModel = viewModel()

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "PREGUNTA:")
        TextField(
            value = vm.questionTextFieldValue,
            onValueChange = {vm.setQuestionTextFieldValue(it)})
        Text(text = "RESPUESTA:")
        TextField(
            value = vm.answerTextFieldValue,
            onValueChange = {vm.setAnswerTextFieldValue(it)})
    }
}