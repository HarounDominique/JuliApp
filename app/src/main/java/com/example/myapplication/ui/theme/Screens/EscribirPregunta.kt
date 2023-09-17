package com.example.myapplication.ui.theme.Screens

import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EscribirPregunta(vm : JuliViewModel, navController: NavController){

    val quicksandFont = FontFamily(Font(R.font.quicksand_regular))

    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

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
                    title = { Text("¿Está bien así?",
                        style = TextStyle(
                            fontFamily = quicksandFont,
                            fontSize = 25.sp)) },
                    text = { Text("Pregunta: "+vm.questionTextFieldValue +"\nRespuesta: "+vm.answerTextFieldValue,
                        style = TextStyle(
                            fontFamily = quicksandFont,
                            fontSize = 20.sp)) },
                    confirmButton = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = { showDialog = false ; Toast.makeText(context, "Pregunta cancelada", Toast.LENGTH_SHORT).show()}) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Cancelar",
                                    tint = Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(onClick = { showDialog = false;
                                vm.addDate(Calendar.getInstance().time);
                                vm.addQuestion(vm.questionTextFieldValue);
                                vm.addAnswer(vm.answerTextFieldValue);
                                Toast.makeText(context, "Pregunta guardada", Toast.LENGTH_SHORT).show();
                                vm.leerTodo();
                                println(vm.listOfQuestions.size)
                                vm.setAnswerTextFieldValue("")
                                vm.setQuestionTextFieldValue("")

                                vm.exportQuestionsAndAnswersToJson(context, vm.listOfQuestions, vm.listOfAnswers);
                                navController.navigate(route = Screens.MainScreen.route)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Confirmar",
                                    tint = Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}
