package com.example.millionaire

data class Question (
    val id: Int,
    val question: String,
    val optionZero: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctAnswer: Int
        ) // JsonObject.get("games").get(0).get("questions")