package com.example.registerusingmvvm.model

import com.example.registerusingmvvm.model.data.ValidatorMessage

interface Validate {
    // function for validate all the input of the user , name , email , password , confirm password
    fun validate(userInput: String): ValidatorMessage
}