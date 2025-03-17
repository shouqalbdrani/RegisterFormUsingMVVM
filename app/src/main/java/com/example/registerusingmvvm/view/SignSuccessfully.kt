package com.example.registerusingmvvm.view

import AppNavigation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignSuccessfully(navController: NavController) {
    val navigator = AppNavigation(navController)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Sign In Successfully!",

            )
        TextButton(onClick = {
            navigator.navigateToSignUp()
        }) {
            Text("Want to Create new Account?")
        }
    }
}

