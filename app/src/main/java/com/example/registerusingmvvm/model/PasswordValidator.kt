package com.example.registerusingmvvm.model

import com.example.registerusingmvvm.model.data.ValidatorMessage

class PasswordValidator : Validate {
    // override the function Validate from interface for Password
    override fun validate(userInput: String): ValidatorMessage {
        return when {
            userInput.isEmpty() -> ValidatorMessage("Failure", "Password cannot be empty")
            userInput.length < 8 -> ValidatorMessage("Failure", "Password must be at least 8 characters")
            else -> ValidatorMessage("Success", "Valid password")
        }
    }
}