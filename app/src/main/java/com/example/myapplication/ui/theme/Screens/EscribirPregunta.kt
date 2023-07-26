package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EscribirPregunta(){

    val quicksandFont = FontFamily(Font(R.font.quicksand_regular))

    val vm : JuliViewModel = viewModel()

    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFFFFF),
                    Color(0xFFFFFFFF)
                    //Color(0xFF7088A0)
                )
            )
        )
        .padding(top = 120.dp), /**poner dp's, porque si no el encabezado (nombre de la app se come el resto de componentes**/
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Pregunta:",
            style = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 30.sp)
        )

        OutlinedTextField(
            value = vm.questionTextFieldValue,
            onValueChange = {vm.setQuestionTextFieldValue(it)},
            label = { Text("Pregunta:") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 20.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Color del borde cuando el TextField tiene el foco
                unfocusedBorderColor = Color.Gray, // Color del borde cuando el TextField no tiene el foco
                focusedLabelColor = Color.Blue, // Color de la etiqueta (label) cuando el TextField tiene el foco
                unfocusedLabelColor = Color.Gray // Color de la etiqueta (label) cuando el TextField no tiene el foco
            )
        )

        Text(text = "Respuesta:",
            style = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 30.sp))

        OutlinedTextField(
            value = vm.answerTextFieldValue,
            onValueChange = {vm.setAnswerTextFieldValue(it)},
            label = { Text("Respuesta:") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 20.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Color del borde cuando el TextField tiene el foco
                unfocusedBorderColor = Color.Gray, // Color del borde cuando el TextField no tiene el foco
                focusedLabelColor = Color.Blue, // Color de la etiqueta (label) cuando el TextField tiene el foco
                unfocusedLabelColor = Color.Gray // Color de la etiqueta (label) cuando el TextField no tiene el foco
            )
        )
/*
        TextField(
            value = vm.questionTextFieldValue,
            onValueChange = {vm.setQuestionTextFieldValue(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textStyle = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 20.sp))





        TextField(
            value = vm.answerTextFieldValue,
            onValueChange = {vm.setAnswerTextFieldValue(it)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textStyle = TextStyle(
                fontFamily = quicksandFont,
                fontSize = 20.sp))

 */

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                // Aquí puedes realizar acciones cuando se hace clic en el botón
                 showDialog = true
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

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Título del Diálogo") },
                    text = { Text("Contenido del Diálogo") },
                    confirmButton = {
                        Button(
                            onClick = {
                                // Acción cuando se presiona el botón de confirmación
                                showDialog = false
                            }
                        ) {
                            Text("Confirmar")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                // Acción cuando se presiona el botón de descartar
                                showDialog = false
                            }
                        ) {
                            Text("Descartar")
                        }
                    }
                )
            }
        }
    }
}