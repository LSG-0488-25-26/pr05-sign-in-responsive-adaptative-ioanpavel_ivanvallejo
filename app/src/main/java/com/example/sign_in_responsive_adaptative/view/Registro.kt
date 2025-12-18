package com.example.sign_in_responsive_adaptative.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sign_in_responsive_adaptative.R
import com.example.sign_in_responsive_adaptative.ui.theme.Gray100
import com.example.sign_in_responsive_adaptative.ui.theme.TextFieldStyles
import com.example.sign_in_responsive_adaptative.view.StandartTextField
import com.example.sign_in_responsive_adaptative.view.ValidatedPasswordField
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel

@Composable
fun Registre(
    viewModel: MainViewModel = viewModel(),
    modifier: Modifier
){
    Card(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            Text(
                text = "Registre",
                style = TextFieldStyles.h4
            )
            Spacer(modifier = Modifier.height(5.dp))
            Divider(
                color = Gray100,
                thickness = 1.dp
            )
            Spacer(modifier = Modifier.height(5.dp))
            StandartTextField(
                value = viewModel.registreUserInfo.value.userName,
                onValueChange = { viewModel.setUserName(it) },
                placeholder = "Nombre de usuario",
                assistiveText = "UserName",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "un",
                modifier = Modifier.width(250.dp)
            )
            StandartTextField(
                value = viewModel.registreUserInfo.value.nombre,
                onValueChange = { viewModel.setName(it) },
                placeholder = "Nombre",
                assistiveText = "Nose admiten numeros ni caracteres especiales",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "n",
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            StandartTextField(
                value = viewModel.registreUserInfo.value.apellido1,
                onValueChange = { viewModel.setSurnameFirst(it) },
                placeholder = "Primer Apellido",
                assistiveText = "Nose admiten numeros ni caracteres especiales",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "sn1",
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            StandartTextField(
                value = viewModel.registreUserInfo.value.apellido2,
                onValueChange = { viewModel.setSurnameSecond(it) },
                placeholder = "Segundo Apellido",
                assistiveText = "Nose admiten numeros ni caracteres especiales",
                regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
                id = "sn2",
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            StandartTextField(
                value = viewModel.registreUserInfo.value.email,
                onValueChange = { viewModel.setEmail(it) },
                placeholder = "Email",
                assistiveText = "Formato email standar ejemplo@ejemplo.com",
                regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"),
                id = "m",
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            StandartTextField(
                value = viewModel.registreUserInfo.value.fechaNacimiento,
                onValueChange = { viewModel.setBirthdate(it) },
                placeholder = "dd/mm/yyyy",
                assistiveText = "Fecha de nacimiento",
                regex = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$"),
                id = "bd",
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ValidatedPasswordField(
                value = viewModel.registreUserInfo.value.passwd,
                onValueChange = { viewModel.setpasswd(it) },
                placeholder = "Contraseña",
                assistiveText = "Mínimo 8 caracteres\n" +
                        "1 letra mayuscula\n" +
                        "1 numero\n" +
                        "1 caracter especial",
                regex = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\/-]).{8,}$"),
                visibilityIconRes = R.drawable.visibility_on,
                visibilityOffIconRes = R.drawable.visibility_off,
                id = "pass",
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            ValidatedPasswordField(
                value = viewModel.registreUserInfo.value.passwdConfirm,
                onValueChange = { viewModel.setpasswdComprobation(it) },
                placeholder = "Repite la contraseña",
                assistiveText = "Repite la Contraseña",
                regex = Regex(".*"),
                visibilityIconRes = R.drawable.visibility_on,
                visibilityOffIconRes = R.drawable.visibility_off,
                id = "passC",
                modifier = Modifier.width(250.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {},
                enabled = viewModel.registerInOrder()
            ) {
                Text("Registraro")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrePreview() {
    Registre(modifier = Modifier.padding(16.dp))
}

