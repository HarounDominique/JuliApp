package com.example.myapplication.ui.theme.Questions

fun myQuestionList() {
    val miDiccionario = mutableMapOf<String, String>()

    // Agregar elementos al diccionario
    miDiccionario["clave1"] = "valor1"
    miDiccionario["clave2"] = "valor2"
    miDiccionario["clave3"] = "valor3"

    // Acceder a los elementos del diccionario
    println(miDiccionario["clave1"]) // Imprimirá "valor1"
    println(miDiccionario["clave2"]) // Imprimirá "valor2"
    println(miDiccionario["clave3"]) // Imprimirá "valor3"

    for ((clave, valor) in miDiccionario.entries) {
        println("Clave: $clave - Valor: $valor")
    }
}