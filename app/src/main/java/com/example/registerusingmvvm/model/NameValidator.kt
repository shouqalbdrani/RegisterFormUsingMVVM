package com.example.registerusingmvvm.model

import com.example.registerusingmvvm.model.data.ValidatorMessage

class NameValidator : Validate {
    // override the function Validate from interface for Name
    override fun validate(userInput: String): ValidatorMessage {
        return when {
            userInput.isEmpty() -> ValidatorMessage("Failure", "Name cannot be empty")
         else ->  ValidatorMessage("Success", "Valid name")
        }
    }
}
