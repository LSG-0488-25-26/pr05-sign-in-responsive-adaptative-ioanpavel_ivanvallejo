import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sign_in_responsive_adaptative.view.LoginSuccessView
import com.example.sign_in_responsive_adaptative.view.LoginView
import com.example.sign_in_responsive_adaptative.view.Registre

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginView(navController) }
        composable("register") { Registre() } // tu pantalla de registro
        composable("login_success/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            LoginSuccessView(navController, username)
        }
    }
}
