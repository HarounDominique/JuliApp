package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Navigation.Navigation
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val randomNumber =
            Random.nextInt(1, 9) // Genera un número aleatorio entre 1 y 8 (ambos incluidos)
        println("Número aleatorio entre 1 y 8: $randomNumber")

        val selectedFontFamily = when (randomNumber) {
            1 -> FontFamily(
                Font(R.font.lr))
            2 -> FontFamily(
                Font(R.font.ar))
            3 -> FontFamily(
                Font(R.font.br))
            4 -> FontFamily(
                Font(R.font.cgr))
            5 -> FontFamily(
                Font(R.font.lor))
            6 -> FontFamily(
                Font(R.font.mqr))
            7 -> FontFamily(
                Font(R.font.mr))
            8 -> FontFamily(
                Font(R.font.ur))
            else -> FontFamily(
                Font(R.font.ur)) // En caso de un número fuera del rango, usar "ur" como fuente por defecto
        }

        val f1 = selectedFontFamily

        //el código anterior varía aleatoriamente la fuente del título de la App

        setContent {
            MyApplicationTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(

                            title = {
                                //para centrar horizontalmente el texto del encabezado necesito colocarlo en un contenedor, en este caso una box.
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 20.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "JuliApp",
                                        style = TextStyle(
                                            fontFamily = f1,
                                            fontSize = 50.sp
                                        )
                                    )
                                }
                            }
                        )
                    },
                    content = {
                        BodyContent(modifier = Modifier.padding(it))
                    }
                )
            }
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        // Aquí puedes agregar más elementos a la columna si lo deseas
        Navigation()
    }
}

@Composable
fun MyButton(texto: String) {
    Button(
        onClick = {
            // Aquí puedes realizar acciones cuando se hace clic en el botón
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Texto del botón
        Text(text = texto)
    }
}