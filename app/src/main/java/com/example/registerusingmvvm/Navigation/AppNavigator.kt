//package com.example.registerusingmvvm.Navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.registerusingmvvm.view.SignInScreen
//import com.example.registerusingmvvm.view.SignSuccessfully
//import com.example.registerusingmvvm.view.SignUpScreen
//import com.example.registerusingmvvm.viewmodel.AuthenticationViewModel
//
//@Composable
//fun AppNavigation(modifier: Modifier = Modifier) {
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = "sign_in",
//        modifier = modifier
//    ) {
//        composable("sign_in") {
//            SignInScreen(viewModel = AuthenticationViewModel(), navController = navController)
//        }
//        composable("sign_up") {
//            SignUpScreen(viewModel = AuthenticationViewModel(), navController = navController)
//        }
//        composable("sign_successfully") {  // Fixed route syntax
//            SignSuccessfully(navController)
//        }
//    }
//}


import androidx.compose.runtime.Composable
import androidx.navigation.NavController

class AppNavigation(
    private val navController: NavController
) {

    fun navigateToSignIn() {
        navController.navigate("sign_in")
    }

    fun navigateToSignUp() {
        navController.navigate("sign_up")
    }
    fun navigateToSuccessfullyScreen() {
        navController.navigate("sign_successfully")
    }
}



