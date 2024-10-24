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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LeerPregunta(vm: JuliViewModel, navController: NavController) {
    val context = LocalContext.current

    // Cargar preguntas y respuestas
    LaunchedEffect(Unit) {
        val (questions, answers) = vm.loadQuestionsAndAnswers(context)
        vm.setQuestionsAndAnswers(questions, answers) // Asumiendo que tienes métodos en tu ViewModel para actualizar las listas
    }

    val questionEntries = vm.listOfQuestions
    val answerEntries = vm.listOfAnswers
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var index by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (!isBottomSheetVisible) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(questionEntries) { questionIndex, entry ->
                    Button(onClick = {
                        isBottomSheetVisible = true
                        index = questionIndex
                    }) {
                        Text(text = entry, style = TextStyle(fontSize = 20.sp))
                    }
                }
            }
        }

        if (isBottomSheetVisible) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
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
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "PREGUNTA: ",
                        style = TextStyle(fontSize = 33.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Text(
                        text = questionEntries.getOrNull(index).toString(),
                        style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Normal),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp)) // Espaciador

                    Text(
                        text = "RESPUESTA: ",
                        style = TextStyle(fontSize = 33.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Text(
                        text = answerEntries.getOrNull(index).toString(),
                        style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Normal),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(50.dp)) // Espaciador
                }
            }
        }
    }
}


