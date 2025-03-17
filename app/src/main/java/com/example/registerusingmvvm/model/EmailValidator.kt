package com.example.registerusingmvvm.model

import com.example.registerusingmvvm.model.data.ValidatorMessage

class EmailValidator : Validate {
    // override the function Validate from interface for Email
    override fun validate(userInput: String): ValidatorMessage {
        return when {
            userInput.isEmpty() -> ValidatorMessage("Failure", "Email cannot be empty")
            !android.util.Patterns.EMAIL_ADDRESS.matcher(userInput).matches() ->
                ValidatorMessage("Failure", "Invalid email format")
            else -> ValidatorMessage("Success", "Valid email")
        }
    }
}