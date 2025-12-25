package com.example.sign_in_responsive_adaptative.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sign_in_responsive_adaptative.R
import com.example.sign_in_responsive_adaptative.model.WindowSizeClass
import com.example.sign_in_responsive_adaptative.ui.theme.Gray100
import com.example.sign_in_responsive_adaptative.ui.theme.TextFieldStyles
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel
import com.example.sign_in_responsive_adaptative.viewModel.getAdaptiveDimensions
import com.example.sign_in_responsive_adaptative.viewModel.rememberWindowSize
import java.time.format.TextStyle

@Composable
fun Registre(
    viewModel: MainViewModel = viewModel(),
    modifier: Modifier = Modifier,
    separation: Dp = 16.dp
) {
    val windowSize = rememberWindowSize()
    val dimensions = getAdaptiveDimensions(windowSize)

    // Ajustar separación según el tamaño de pantalla
    val adaptiveSeparation = when (windowSize.width) {
        WindowSizeClass.COMPACT -> 12.dp
        WindowSizeClass.MEDIUM -> 16.dp
        WindowSizeClass.EXPANDED -> 20.dp
    }

    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    when (windowSize.width) {
                        WindowSizeClass.COMPACT -> 50.dp
                        WindowSizeClass.MEDIUM -> 60.dp
                        WindowSizeClass.EXPANDED -> 70.dp
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Registre",
                style = TextFieldStyles.h4.copy(
                    fontSize = when (windowSize.width) {
                        WindowSizeClass.COMPACT -> 20.sp
                        WindowSizeClass.MEDIUM -> 24.sp
                        WindowSizeClass.EXPANDED -> 28.sp
                    }
                )
            )
        }

        Divider(
            color = Gray100,
            thickness = dimensions.dividerThickness
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = when (windowSize.width) {
                        WindowSizeClass.COMPACT -> 16.dp
                        WindowSizeClass.MEDIUM -> 32.dp
                        WindowSizeClass.EXPANDED -> 48.dp
                    }
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(adaptiveSeparation))

            StandartTextField(
                value = viewModel.registreUserInfo.value.userName,
                onValueChange = { viewModel.setUserName(it) },
                placeholder = "Nombre de usuario",
                assistiveText = "UserName",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "un",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            StandartTextField(
                value = viewModel.registreUserInfo.value.nombre,
                onValueChange = { viewModel.setName(it) },
                placeholder = "Nombre",
                assistiveText = "No se admiten números ni caracteres especiales",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "n",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            StandartTextField(
                value = viewModel.registreUserInfo.value.apellido1,
                onValueChange = { viewModel.setSurnameFirst(it) },
                placeholder = "Primer Apellido",
                assistiveText = "No se admiten números ni caracteres especiales",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "sn1",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            StandartTextField(
                value = viewModel.registreUserInfo.value.apellido2,
                onValueChange = { viewModel.setSurnameSecond(it) },
                placeholder = "Segundo Apellido",
                assistiveText = "No se admiten números ni caracteres especiales",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "sn2",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            StandartTextField(
                value = viewModel.registreUserInfo.value.email,
                onValueChange = { viewModel.setEmail(it) },
                placeholder = "Email",
                assistiveText = "Formato email estándar ejemplo@ejemplo.com",
                regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"),
                id = "m",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            StandartTextField(
                value = viewModel.registreUserInfo.value.fechaNacimiento,
                onValueChange = { viewModel.setBirthdate(it) },
                placeholder = "dd/mm/yyyy",
                assistiveText = "Fecha de nacimiento",
                regex = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$"),
                id = "bd",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            ValidatedPasswordField(
                value = viewModel.registreUserInfo.value.passwd,
                onValueChange = { viewModel.setpasswd(it) },
                placeholder = "Contraseña",
                assistiveText = "Mínimo 8 caracteres\n1 letra mayúscula\n1 número\n1 carácter especial",
                regex = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\/-]).{8,}$"),
                visibilityIconRes = R.drawable.visibility_on,
                visibilityOffIconRes = R.drawable.visibility_off,
                id = "pass",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            ValidatedPasswordField(
                value = viewModel.registreUserInfo.value.passwdConfirm,
                onValueChange = { viewModel.setpasswdComprobation(it) },
                placeholder = "Repite la contraseña",
                assistiveText = "Repite la Contraseña",
                regex = Regex(".*"),
                visibilityIconRes = R.drawable.visibility_on,
                visibilityOffIconRes = R.drawable.visibility_off,
                id = "passC",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = dimensions.horizontalPadding)
            ) {
                Checkbox(
                    checked = viewModel.registreUserInfo.value.tc,
                    onCheckedChange = { viewModel.IsValidTermsConditions(it) }
                )
                Text(
                    text = "Acepto los términos",
                    //style = TextStyle(
                        fontSize = when (windowSize.width) {
                            WindowSizeClass.COMPACT -> 14.sp
                            WindowSizeClass.MEDIUM -> 16.sp
                            WindowSizeClass.EXPANDED -> 18.sp
                        }
                    //)
                )
            }

            Spacer(modifier = Modifier.height(adaptiveSeparation))

            Button(
                onClick = {},
                enabled = viewModel.registerInOrder(),
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
                    "Registrar",
                    fontSize = when (windowSize.width) {
                        WindowSizeClass.COMPACT -> 14.sp
                        WindowSizeClass.MEDIUM -> 16.sp
                        WindowSizeClass.EXPANDED -> 18.sp
                    }
                )
            }

            Spacer(modifier = Modifier.height(adaptiveSeparation))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrePreview() {
    Registre(modifier = Modifier.padding(16.dp),
        separation = 15.dp)
}

