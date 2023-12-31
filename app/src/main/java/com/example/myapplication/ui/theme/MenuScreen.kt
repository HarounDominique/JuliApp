package com.example.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.myapplication.ui.theme.Screens.Screens
import com.example.myapplication.ui.theme.ViewModel.JuliViewModel

@Composable
fun MenuScreen(navController: NavController) {

    val quicksandFont = FontFamily(Font(R.font.quicksand_regular))
    val vm : JuliViewModel = viewModel()
    val context = LocalContext.current

    vm.importQuestionsAndAnswersFromJson(context, vm)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFA8BFD8)
                    )
                )
            ),
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
        Button(onClick = { navController.navigate(route = Screens.Boton2.route);  vm.leerTodo()}) {
            Text(text = "Leer mis preguntas",
                style = TextStyle(
                    fontFamily = quicksandFont,
                    fontSize = 30.sp))
        }
    }
}