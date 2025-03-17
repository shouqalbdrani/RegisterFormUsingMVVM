package com.example.registerusingmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.registerusingmvvm.model.*
import com.example.registerusingmvvm.model.data.ValidatorMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthenticationViewModel : ViewModel() {
    // Create instance
    private val emailValidator = EmailValidator()
    private val nameValidator = NameValidator()
    private val passwordValidator = PasswordValidator()
    private val confirmPasswordValidator = ConfirmPasswordValidator()

    // Update the values
    private val _emailValidationResult = MutableStateFlow(ValidatorMessage("", ""))
    val emailValidationResult: StateFlow<ValidatorMessage> = _emailValidationResult.asStateFlow()

    private val _nameValidationResult = MutableStateFlow(ValidatorMessage("", ""))
    val nameValidationResult: StateFlow<ValidatorMessage> = _nameValidationResult.asStateFlow()

    private val _passwordValidationResult = MutableStateFlow(ValidatorMessage("", ""))
    val passwordValidationResult: StateFlow<ValidatorMessage> = _passwordValidationResult.asStateFlow()

    private val _confirmPasswordResult = MutableStateFlow(ValidatorMessage("", ""))
    val passwordConfirmResult: StateFlow<ValidatorMessage> = _confirmPasswordResult.asStateFlow()


    // Email validation
    fun validateEmail(email: String) { // holds the email validation result and function that updates the current state
        _emailValidationResult.update { emailValidator.validate(email) }
    }

    // Name validation
    fun validateName(name: String) {
        _nameValidationResult.update { nameValidator.validate(name) }
    }

    // Password validation
    fun validatePassword(password: String) {
        _passwordValidationResult.update { passwordValidator.validate(password) }
    }

    fun validateConfirmPassword(confirmPassword: String, password: String) {
        _confirmPasswordResult.update { confirmPasswordValidator.validate(confirmPassword, password) }
    }

   // Sign In data validation
    fun validateSignInData(
        email: String,
        password: String
    ): ValidatorMessage {
        val emailResult = emailValidator.validate(email)
        if (emailResult.isSuccess != "Success") return emailResult

        val passwordResult = passwordValidator.validate(password)
        if (passwordResult.isSuccess != "Success") return passwordResult

        return ValidatorMessage("Success", "All fields is valid")
    }


    // Sign-Up data validation
    fun validateSignUpData(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): ValidatorMessage {
        val nameResult = nameValidator.validate(name)
        if (nameResult.isSuccess != "Success") return nameResult

        val emailResult = emailValidator.validate(email)
        if (emailResult.isSuccess != "Success") return emailResult

        val passwordResult = passwordValidator.validate(password)
        if (passwordResult.isSuccess != "Success") return passwordResult

        val confirmPasswordResult = confirmPasswordValidator.validate(confirmPassword, password)
        if (confirmPasswordResult.isSuccess != "Success") return confirmPasswordResult

        return ValidatorMessage("Success", "All fields are valid")
    }
}
