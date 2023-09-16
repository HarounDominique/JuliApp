package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LeerPregunta(vm: JuliViewModel, navController: NavController) {

    val questionEntries = vm.listOfQuestions;
    val answerEntries = vm.listOfAnswers;
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var questionChoosed = "";
    var answerChoosed = "";
    var index = 0;

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (questionEntries.isNotEmpty()) {
            var selectedQuestionIndex = -1;
            questionEntries.forEach { entry ->
                selectedQuestionIndex++
                index = selectedQuestionIndex;
                Button(onClick = {
                    isBottomSheetVisible = true;
                    // Acción cuando se hace clic en el botón
                    // Por ejemplo, puedes mostrar el texto de la entrada en la consola
                    //guardo la pregunta y su respuesta en las variables que posteriormente se mostrarán en el bottomsheet:
                    println("El índice de esta pregunta es: " + index)

                    //println("LOG: Se hizo clic en el botón de pregunta")
                    //entry.get
                }) {
                    Text(text = entry, style = TextStyle(fontSize = 20.sp))
                }
            }
        }
        /*
                    if (isBottomSheetVisible) {
                        ModalBottomSheetLayout(
                            sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded),
                            sheetContent = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                        .padding(16.dp)
                                        .background(Color.Gray),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "Contenido del Bottom Sheet")
                                    Text(text = "PREGUNTA: "+questionEntries.get(index).toString())
                                    Text(text = "RESPUESTA: "+answerEntries.get(index).toString())

                                }
                            }
                        ) {
                            // Contenido principal de la pantalla
                            Text(text = "PREGUNTA: "+questionEntries.get(index).toString())
                            Text(text = "RESPUESTA: "+answerEntries.get(index).toString())
                        }
                    }

         */


        if (isBottomSheetVisible) {
            ModalBottomSheetLayout(
                sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded),
                sheetContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(16.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFFFFFFF),
                                        Color(0xFFA8BFD8)
                                    )
                                )
                            ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "PREGUNTA: ",
                                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = questionEntries.get(index).toString(),
                                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Normal)
                            )

                            Spacer(modifier = Modifier.height(16.dp)) // Espaciador

                            Text(
                                text = "RESPUESTA: ",
                                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = answerEntries.get(index).toString(),
                                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Normal)
                            )
                            Spacer(modifier = Modifier.height(16.dp)) // Espaciador
                            Spacer(modifier = Modifier.height(16.dp)) // Espaciador
                            Spacer(modifier = Modifier.height(16.dp)) // Espaciador
                        }
                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Contenido principal de la pantalla
                    Button(onClick = { navController.navigate(route = Screens.Boton2.route) }) {
                        Text(
                            text = "VOLVER A MIS PREGUNTAS"
                        )
                    }
                }
            }
        }

    }
}

