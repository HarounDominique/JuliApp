package com.example.myapplication.ui.theme.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Date
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File
import java.io.FileWriter
import java.io.IOException

class JuliViewModel(): ViewModel() {

    //regionESTADO

    private var _listOfQuestions = mutableListOf<String>()
    val listOfQuestions get() = _listOfQuestions

    private var _listOfAnswers = mutableListOf<String>()
    val listOfAnswers get() = _listOfAnswers

    private var _listOfDate = mutableListOf<Date>()
    val listOfDate get() = _listOfDate


    private var _questionTextFieldValue by mutableStateOf("")
    val questionTextFieldValue get() = _questionTextFieldValue

    private var _answerTextFieldValue by mutableStateOf("")
    val answerTextFieldValue get() = _answerTextFieldValue

    //endregion

    //regionFUNCIONES

    fun addQuestion(pregunta : String){
        _listOfQuestions.add(pregunta)
    }

    fun addAnswer(respuesta : String){
        _listOfAnswers.add(respuesta)
    }

    fun addDate(fecha : Date){
        _listOfDate.add(fecha)
    }


    fun setQuestionTextFieldValue(text:String){
        _questionTextFieldValue=text
    }
    fun setAnswerTextFieldValue(text:String){
        _answerTextFieldValue=text
    }

    fun leerTodo() {
        println("Iniciando leerTodo")
        _listOfQuestions.forEach { element ->
            println(element)
        }
        _listOfAnswers.forEach { element ->
            println(element)
        }
        _listOfDate.forEach { element ->
            println(element)
        }
        println("Fin de leerTodo")
    }

    //persistencia:

    data class QA(val pregunta: String, val respuesta: String)

    fun exportQuestionsAndAnswersToJson(questions: List<String>, answers: List<String>) {
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()

        val qaList = mutableListOf<QA>()

        // Crear una lista de objetos QA a partir de las listas de preguntas y respuestas
        for (i in 0 until questions.size.coerceAtMost(answers.size)) {
            val pregunta = questions[i]
            val respuesta = answers[i]
            qaList.add(QA(pregunta, respuesta))
        }

        // Crear un JSON a partir de la lista de QA
        val json = gson.toJson(qaList)

        try {
            val outputPath = "questions_and_answers.json"

            // Crear un archivo en la unidad D:\ con el nombre "questions_and_answers.json"
            val outputFile = File(outputPath)

            // Escribir el JSON en el archivo en la unidad D:\
            val fileWriter = FileWriter(outputFile)
            fileWriter.write(json)
            fileWriter.flush()
            fileWriter.close()

            println("Las preguntas y respuestas se han guardado en el archivo JSON.")
        } catch (e: IOException) {
            e.printStackTrace()
            println("ERROR: Las preguntas y respuestas NO se han guardado en el archivo JSON.")
        }
    }

    //endregion
}