package com.example.myapplication.ui.theme.ViewModel

import androidx.lifecycle.ViewModel

class Ej01ViewModel(): ViewModel() {

    //ESTADO

    private var _myDiccionary = mutableMapOf<String, String>()
    val myDiccionary get() = _myDiccionary

    //FUNCIONES

    fun printQuestionAnswer(clave:String, valor:String){
        for ((clave, valor) in _myDiccionary.entries) {
            println("Clave: $clave - Valor: $valor")
        }
    }

    fun deleteQuestion(clave: String){
        _myDiccionary.remove(clave)
    }

    fun clearDictionary(){
        val clavesAEliminar = _myDiccionary.keys.toList()
        clavesAEliminar.forEach { clave ->
            _myDiccionary.remove(clave)
        }
    }
}