package com.example.registerusingmvvm.view

import AppNavigation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.registerusingmvvm.viewmodel.AuthenticationViewModel

@Composable
fun SignUpScreen(viewModel: AuthenticationViewModel, navController: NavController) { // //  for handle business logic of sign up page
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var signUpError by remember { mutableStateOf<String?>(null) }

    val navigator = AppNavigation(navController)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 100.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
                viewModel.validateEmail(it)
            },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
                viewModel.validatePassword(it)
            },
            label = {
                Text("Password")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                viewModel.validateConfirmPassword(it, password)
            },

            label = {
                Text("Confirm Password")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val result = viewModel.validateSignUpData(name, email, password, confirmPassword)
                if (result.isSuccess == "Success") {
                    navigator.navigateToSignIn() // Navigate to Sign In after successful registration
                } else {
                    signUpError = result.message
                }
            }
        ) {
            Text("Sign Up")
        }

        signUpError?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(it, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { navController.navigate("sign_in") }) {
            Text("Already have an account? Sign In")
        }
    }
}

