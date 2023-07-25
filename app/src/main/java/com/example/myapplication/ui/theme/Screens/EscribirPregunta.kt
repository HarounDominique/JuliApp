package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.MyButton
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EscribirPregunta(){

    val quicksandFont = FontFamily(Font(R.font.quicksand_regular))

    val vm : JuliViewModel = viewModel()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 120.dp), /**poner dp's, porque si no el encabezado (nombre de la app se come el resto de componentes**/
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Pregunta:",
            style = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 30.sp)
        )

        TextField(
            value = vm.questionTextFieldValue,
            onValueChange = {vm.setQuestionTextFieldValue(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textStyle = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 20.sp))

        Text(text = "Respuesta:",
            style = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 30.sp))

        TextField(
            value = vm.answerTextFieldValue,
            onValueChange = {vm.setAnswerTextFieldValue(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textStyle = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 20.sp))

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                // Aquí puedes realizar acciones cuando se hace clic en el botón
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Texto del botón
            Text(text = "Guardar pregunta",
                style = TextStyle(
                    fontFamily = quicksandFont,
                    fontSize = 30.sp))
        }
    }
}