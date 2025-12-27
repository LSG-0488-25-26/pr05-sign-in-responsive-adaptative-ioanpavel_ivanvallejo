package com.example.sign_in_responsive_adaptative.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sign_in_responsive_adaptative.model.WindowSizeClass
import com.example.sign_in_responsive_adaptative.viewModel.getAdaptiveDimensions
import com.example.sign_in_responsive_adaptative.viewModel.rememberWindowSize

@Composable
fun LoginView(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
) {
    val windowSize = rememberWindowSize()
    val dimensions = getAdaptiveDimensions(windowSize)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .width(dimensions.fieldWidth + 40.dp)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Password
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                // Error
                if (showError) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Credenciales incorrectas",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        if (email == "test@test.com" && password == "1234") {
                            showError = false
                            navController.navigate("login_success/${email}")
                        } else {
                            showError = true
                        }
                    }) {
                        Text("Acceder")
                    }
                    Button(onClick = {
                        navController.navigate("register")
                    }) {
                        Text("Crear cuenta")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginView(navController = navController)
}