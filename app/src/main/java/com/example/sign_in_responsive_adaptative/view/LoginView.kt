package com.example.sign_in_responsive_adaptative.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.example.sign_in_responsive_adaptative.R
import com.example.sign_in_responsive_adaptative.model.WindowSizeClass
import com.example.sign_in_responsive_adaptative.ui.theme.Gray100
import com.example.sign_in_responsive_adaptative.ui.theme.Red50
import com.example.sign_in_responsive_adaptative.ui.theme.TextFieldStyles
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
    var passwordVisible by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    // Validación simple
    val isEmailValid = email.isEmpty() ||
            Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matches(email)
    val isPasswordValid = password.isEmpty() || password.length >= 4

    val canLogin = email.isNotEmpty() && password.isNotEmpty() &&
            isEmailValid && isPasswordValid

    // Ajustes adaptativos
    val cardWidth = when (windowSize.width) {
        WindowSizeClass.COMPACT -> 0.9f // 90% del ancho
        WindowSizeClass.MEDIUM -> 0.7f   // 70% del ancho
        WindowSizeClass.EXPANDED -> 0.5f // 50% del ancho
    }

    val verticalPadding = when (windowSize.width) {
        WindowSizeClass.COMPACT -> 16.dp
        WindowSizeClass.MEDIUM -> 24.dp
        WindowSizeClass.EXPANDED -> 32.dp
    }

    val spacerHeight = when (windowSize.width) {
        WindowSizeClass.COMPACT -> 12.dp
        WindowSizeClass.MEDIUM -> 16.dp
        WindowSizeClass.EXPANDED -> 20.dp
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(cardWidth)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        horizontal = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 16.dp
                            WindowSizeClass.MEDIUM -> 24.dp
                            WindowSizeClass.EXPANDED -> 32.dp
                        },
                        vertical = verticalPadding
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Título
                Text(
                    text = "Iniciar Sesión",
                    style = TextFieldStyles.h4.copy(
                        fontSize = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 24.sp
                            WindowSizeClass.MEDIUM -> 28.sp
                            WindowSizeClass.EXPANDED -> 32.sp
                        }
                    )
                )

                Spacer(modifier = Modifier.height(verticalPadding))

                Divider(
                    color = Gray100,
                    thickness = dimensions.dividerThickness
                )

                Spacer(modifier = Modifier.height(verticalPadding))

                // Campo Email
                StandartTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "Email",
                    assistiveText = "Formato email estándar ejemplo@ejemplo.com",
                    regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"),
                    id = "m",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Password
                ValidatedPasswordField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Contraseña",
                    assistiveText = "Mínimo 8 caracteres\n1 letra mayúscula\n1 número\n1 carácter especial",
                    regex = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\/-]).{8,}$"),
                    visibilityIconRes = R.drawable.visibility_on,
                    visibilityOffIconRes = R.drawable.visibility_off,
                    id = "pass",
                    modifier = Modifier.fillMaxWidth()
                )

                // Mensaje de error
                if (showError) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Credenciales incorrectas. Intenta de nuevo.",
                        color = Red50,
                        fontSize = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 12.sp
                            WindowSizeClass.MEDIUM -> 14.sp
                            WindowSizeClass.EXPANDED -> 16.sp
                        },
                        modifier = Modifier.padding(horizontal = dimensions.horizontalPadding)
                    )
                }

                Spacer(modifier = Modifier.height(verticalPadding))

                // Botón Acceder
                Button(
                    onClick = {
                        if (email == "test@test.com" && password == "Abc123???") {
                            showError = false
                            navController.navigate("SelectionView")
                        } else {
                            showError = true
                        }
                    },
                    enabled = canLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            when (windowSize.width) {
                                WindowSizeClass.COMPACT -> 48.dp
                                WindowSizeClass.MEDIUM -> 52.dp
                                WindowSizeClass.EXPANDED -> 56.dp
                            }
                        )
                ) {
                    Text(
                        text = "Acceder",
                        fontSize = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 14.sp
                            WindowSizeClass.MEDIUM -> 16.sp
                            WindowSizeClass.EXPANDED -> 18.sp
                        }
                    )
                }

                Spacer(modifier = Modifier.height(spacerHeight))

                // Divisor con texto
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.weight(1f))
                    Text(
                        text = "o",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Gray100,
                        fontSize = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 12.sp
                            WindowSizeClass.MEDIUM -> 14.sp
                            WindowSizeClass.EXPANDED -> 16.sp
                        }
                    )
                    Divider(modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(spacerHeight))

                // Botón Crear cuenta
                OutlinedButton(
                    onClick = {
                        navController.navigate("register")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            when (windowSize.width) {
                                WindowSizeClass.COMPACT -> 48.dp
                                WindowSizeClass.MEDIUM -> 52.dp
                                WindowSizeClass.EXPANDED -> 56.dp
                            }
                        )
                ) {
                    Text(
                        text = "Crear cuenta nueva",
                        fontSize = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 14.sp
                            WindowSizeClass.MEDIUM -> 16.sp
                            WindowSizeClass.EXPANDED -> 18.sp
                        }
                    )
                }
            }
        }
    }
}