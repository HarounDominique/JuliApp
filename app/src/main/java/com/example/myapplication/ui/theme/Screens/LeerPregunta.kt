package com.example.myapplication.ui.theme.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LeerPregunta(vm : JuliViewModel, navController: NavController){

    val questionEntries = vm.listOfQuestions;
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (questionEntries.isNotEmpty()) {
            questionEntries.forEach { entry ->
                Button(onClick = {
                    isBottomSheetVisible = true;
                    // Acción cuando se hace clic en el botón
                    // Por ejemplo, puedes mostrar el texto de la entrada en la consola
                    println("LOG: Se hizo clic en el botón de pregunta")
                    //entry.get
                }) {
                    Text(text = entry, style = TextStyle(fontSize = 20.sp))
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { isBottomSheetVisible = true }) {
                Text(text = "Mostrar Bottom Sheet")
            }

            if (isBottomSheetVisible) {
                ModalBottomSheetLayout(
                    sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded),
                    sheetContent = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Contenido del Bottom Sheet")
                        }
                    }
                ) {
                    // Contenido principal de la pantalla
                }
            }
        }

    }
}

