package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val quizQuestions = QUIZ_QUESTIONS.toMutableList()
    private val questionAdapter = QuestionAdapter(quizQuestions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}