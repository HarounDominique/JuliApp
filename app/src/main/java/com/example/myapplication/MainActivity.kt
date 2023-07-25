package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Navigation.Navigation

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lobsterFontFamily = FontFamily(
            Font(R.font.lobster_regular) // Nombre del archivo de la fuente sin extensión
        )
        setContent {
            MyApplicationTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                //para centrar horizontalmente el texto del encabezado necesito colocarlo en un contenedor, en este caso una box.
                                Box(
                                    modifier = Modifier.fillMaxSize()
                                        .padding(top = 20.dp),
                                    contentAlignment = Alignment.Center
                                ) { Text(text = "JuliApp",
                                    style = TextStyle(
                                        fontFamily = lobsterFontFamily,
                                        fontSize = 50.sp
                                    )
                                ) }
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
fun MyButton(texto:String) {
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

