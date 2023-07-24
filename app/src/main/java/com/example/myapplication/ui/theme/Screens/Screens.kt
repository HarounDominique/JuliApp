package com.example.myapplication.ui.theme.Screens

sealed class Screens(val route: String){
    object MainScreen: Screens("initial_screen")

    object Boton1: Screens("boton1")
    object Boton2: Screens("boton2")
    //object Boton3: Screens("boton3")

}