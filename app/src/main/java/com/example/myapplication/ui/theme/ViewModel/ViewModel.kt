package com.example.myapplication.ui.theme.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.Date

class JuliViewModel : ViewModel() {

    // region ESTADO

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

    // endregion

    // region FUNCIONES

    fun setQuestionsAndAnswers(questions: List<String>, answers: List<String>) {
        _listOfQuestions.clear()
        _listOfAnswers.clear()
        _listOfQuestions.addAll(questions)
        _listOfAnswers.addAll(answers)
    }

    fun addQuestion(pregunta: String) {
        _listOfQuestions.add(pregunta)
    }

    fun addAnswer(respuesta: String) {
        _listOfAnswers.add(respuesta)
    }

    fun addDate(fecha: Date) {
        _listOfDate.add(fecha)
    }

    fun setQuestionTextFieldValue(text: String) {
        _questionTextFieldValue = text
    }

    fun setAnswerTextFieldValue(text: String) {
        _answerTextFieldValue = text
    }

    fun leerTodo() {
        println("Iniciando leerTodo")
        _listOfQuestions.forEach { println(it) }
        _listOfAnswers.forEach { println(it) }
        _listOfDate.forEach { println(it) }
        println("Fin de leerTodo")
    }

    // Persistencia: exportar a JSON

    data class QA(val pregunta: String, val respuesta: String)

    fun exportQuestionsAndAnswersToJson(context: Context, questions: List<String>, answers: List<String>) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val qaList = mutableListOf<QA>()

        for (i in 0 until questions.size.coerceAtMost(answers.size)) {
            qaList.add(QA(questions[i], answers[i]))
        }

        val json = gson.toJson(qaList)
        try {
            val fileName = "questions_and_answers.json"
            val directory = context.filesDir
            val outputFile = File(directory, fileName)
            FileOutputStream(outputFile).use { it.write(json.toByteArray()) }
            Toast.makeText(context, "Preguntas y respuestas guardadas correctamente.", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "ERROR: No se pudo guardar el archivo JSON.", Toast.LENGTH_SHORT).show()
        }
    }

    fun importQuestionsAndAnswersFromJson(context: Context, vm: JuliViewModel): Boolean {
        val fileName = "questions_and_answers.json"
        val file = File(context.filesDir, fileName)

        if (!file.exists()) {
            Toast.makeText(context, "El archivo JSON no existe en el directorio.", Toast.LENGTH_SHORT).show()
            return false
        }

        return try {
            val json = file.readText()
            val gson = Gson()
            val qaListType = object : TypeToken<List<QA>>() {}.type
            val qaList: List<QA> = gson.fromJson(json, qaListType)

            vm.listOfQuestions.addAll(qaList.map { it.pregunta })
            vm.listOfAnswers.addAll(qaList.map { it.respuesta })

            true
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "ERROR: No se pudo leer el archivo JSON.", Toast.LENGTH_SHORT).show()
            false
        }
    }

    // Persistencia con SharedPreferences

    fun saveQuestionsAndAnswers(context: Context, questions: List<String>, answers: List<String>) {
        val sharedPreferences = context.getSharedPreferences("QA_Prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("questions_size", questions.size)

        for (i in questions.indices) {
            editor.putString("question_$i", questions[i])
            editor.putString("answer_$i", answers[i])
        }

        editor.apply()
        Toast.makeText(context, "Preguntas y respuestas guardadas en SharedPreferences.", Toast.LENGTH_SHORT).show()
    }

    fun loadQuestionsAndAnswers(context: Context): Pair<List<String>, List<String>> {
        val sharedPreferences = context.getSharedPreferences("QA_Prefs", Context.MODE_PRIVATE)
        val size = sharedPreferences.getInt("questions_size", 0)

        val questions = mutableListOf<String>()
        val answers = mutableListOf<String>()

        for (i in 0 until size) {
            questions.add(sharedPreferences.getString("question_$i", "") ?: "")
            answers.add(sharedPreferences.getString("answer_$i", "") ?: "")
        }

        return Pair(questions, answers)
    }

    // endregion
}
