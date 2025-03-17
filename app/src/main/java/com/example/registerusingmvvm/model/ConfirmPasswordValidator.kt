package com.example.registerusingmvvm.model

import com.example.registerusingmvvm.model.data.ValidatorMessage

class ConfirmPasswordValidator {
    // override the function Validate from interface for Confirm Password
    fun validate(confirmPassword: String, originalPassword: String): ValidatorMessage {
        return when {
            confirmPassword.isEmpty() -> ValidatorMessage("Failure", "Confirm Password cannot be empty")
            confirmPassword != originalPassword -> ValidatorMessage("Failure", "Passwords do not match")
            else -> ValidatorMessage("Success", "Passwords match")
        }
    }

}