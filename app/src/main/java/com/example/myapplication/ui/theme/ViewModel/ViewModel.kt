package com.example.myapplication.ui.theme.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.util.Date
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class JuliViewModel(): ViewModel() {

    //regionESTADO

    val pathToResources = "src/main/java/com/example/myapplication/resources"

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

    fun exportQuestionsAndAnswersToJson(context: Context, questions: List<String>, answers: List<String>) {
        val gson = GsonBuilder().setPrettyPrinting().create()

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
            val fileName = "questions_and_answers.json"

            // Obtener el directorio de archivos privado de la aplicación
            //val directory = context.filesDir
            val directory = pathToResources

            // Crear un archivo en el directorio de archivos privado
            val outputFile = File(directory, fileName)

            // Escribir el JSON en el archivo
            val fileOutputStream = FileOutputStream(outputFile)
            fileOutputStream.write(json.toByteArray())
            fileOutputStream.close()

            println("Las preguntas y respuestas se han guardado en el archivo JSON en el directorio de archivos privados.")
            Toast.makeText(context, "Las preguntas y respuestas se han guardado en el archivo JSON en el directorio de archivos privados.", Toast.LENGTH_SHORT).show();
        } catch (e: IOException) {
            e.printStackTrace()
            println("ERROR: Las preguntas y respuestas NO se han guardado en el archivo JSON.")
            Toast.makeText(context, "ERROR: Las preguntas y respuestas NO se han guardado en el archivo JSON.", Toast.LENGTH_SHORT).show();
        }
    }


    fun importQuestionsAndAnswersFromJson(context: Context, vm: JuliViewModel): Boolean {
        val fileName = "questions_and_answers.json"
        //val file = File(context.filesDir, fileName)
        val file = File(pathToResources, fileName)

        if (!file.exists()) {
            // El archivo JSON no existe en el directorio
            println("El archivo JSON no existe en el directorio.")
            Toast.makeText(context, "El archivo JSON no existe en el directorio.", Toast.LENGTH_SHORT).show();
            return false
        }

        try {
            val json = file.readText()
            val gson = Gson()
            val qaListType = object : TypeToken<List<QA>>() {}.type

            val qaList: List<QA> = gson.fromJson(json, qaListType)

            val questions = mutableListOf<String>()
            val answers = mutableListOf<String>()

            for (qa in qaList) {
                questions.add(qa.pregunta)
                answers.add(qa.respuesta)
            }

            // Agregar preguntas a vm.listOfQuestions
            vm.listOfQuestions.addAll(questions)

            // Agregar respuestas a vm.listOfAnswers
            vm.listOfAnswers.addAll(answers)

            return true
        } catch (e: IOException) {
            e.printStackTrace()
            println("ERROR: No se pudo leer el archivo JSON.")
            Toast.makeText(context, "ERROR: No se pudo leer el archivo JSON.", Toast.LENGTH_SHORT).show();
            return false
        }
    }

    //endregion
}