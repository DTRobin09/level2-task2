package com.example.madlevel2task2

data class Question(val question: String, val correctAnswer: Boolean)

val QUIZ_QUESTIONS = listOf(
    Question("Arch uses pacman as package manager", true),
    Question("There are 104 days of summer vacation", false),
    Question("Linux is the most popular OS for gaming", false),
    Question("The Russians were the first on the moon", false),
    Question("By default, Kotlin compiles down to Java", true),
)