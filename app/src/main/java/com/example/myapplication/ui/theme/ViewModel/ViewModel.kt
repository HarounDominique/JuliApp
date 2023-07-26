package com.example.myapplication.ui.theme.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Date

class JuliViewModel(): ViewModel() {

    //ESTADO

    private var _listOfQuestions = mutableListOf("")
    val listOfQuestions get() = _listOfQuestions

    private var _listOfAnswers = mutableListOf("")
    val listOfAnswers get() = _listOfAnswers

    private var _listOfDate = mutableListOf<Date>()
    val listOfDate get() = _listOfDate



    private var _myDiccionary = mutableMapOf<String, String>()
    val myDiccionary get() = _myDiccionary

    private var _questionTextFieldValue by mutableStateOf("")
    val questionTextFieldValue get() = _questionTextFieldValue

    private var _answerTextFieldValue by mutableStateOf("")
    val answerTextFieldValue get() = _answerTextFieldValue

    //FUNCIONES

    fun addQuestion(pregunta : String){
        _listOfQuestions.add(pregunta)
    }

    fun addAnswer(respuesta : String){
        _listOfAnswers.add(respuesta)
    }

    fun addDate(fecha : Date){
        _listOfDate.add(fecha)
    }



    fun printQuestionAnswer(clave:String, valor:String){
        for ((clave, valor) in _myDiccionary.entries) {
            println("Clave: $clave - Valor: $valor")
        }
    }

    fun setQuestionTextFieldValue(text:String){
        _questionTextFieldValue=text
    }
    fun setAnswerTextFieldValue(text:String){
        _answerTextFieldValue=text
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