package com.example.registerusingmvvm.view

import AppNavigation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.registerusingmvvm.viewmodel.AuthenticationViewModel

@Composable
fun SignInScreen(viewModel: AuthenticationViewModel, navController: NavController) { //  for handle business logic of sign in page
    // Create state variables
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var signInError by remember { mutableStateOf("") }
    val navigator = AppNavigation(navController)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField( // text field for sign in page
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField( // text field for password in page
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { // check the sign in validate using view model
            val result = viewModel.validateSignInData(email, password)
            if (result.isSuccess == "Success") {
                navigator.navigateToSuccessfullyScreen() // navigate to the page sign in successfully
            } else {
                signInError = result.message // show error message
            }
        }) {
            Text("Sign In")
        }

        if (signInError.isNotEmpty()) { // ensures the error message is not empty.
            Spacer(modifier = Modifier.height(8.dp))
            Text(signInError, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = {
            navigator.navigateToSignUp()
        }) {
            Text("Don't have an account? Sign Up")
        }
    }
}
