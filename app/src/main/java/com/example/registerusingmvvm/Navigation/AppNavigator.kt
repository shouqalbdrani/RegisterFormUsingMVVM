
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



