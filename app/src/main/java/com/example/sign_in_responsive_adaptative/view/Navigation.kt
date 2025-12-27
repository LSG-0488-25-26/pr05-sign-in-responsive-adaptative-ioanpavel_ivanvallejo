package com.example.sign_in_responsive_adaptative.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel

@Composable
fun AppNavHost(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "SelectionView") {
        composable("SelectionView") { SelectionView(
            navController,
            viewModel = viewModel
        ) }
        composable("login") { LoginView(navController) }
        composable("register") { Registre(navController) }
        composable("login_success/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: ""
            LoginSuccessView(navController, username)
        }
    }
}