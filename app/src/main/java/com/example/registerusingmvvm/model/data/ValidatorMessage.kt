package com.example.registerusingmvvm.model.data

data class ValidatorMessage( // handle massage
    val isSuccess: String, // Failure or Success
    val message: String // The message will appear to the user
)
