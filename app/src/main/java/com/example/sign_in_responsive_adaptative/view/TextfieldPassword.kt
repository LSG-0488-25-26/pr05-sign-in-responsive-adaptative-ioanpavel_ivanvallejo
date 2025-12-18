package com.example.sign_in_responsive_adaptative.view


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sign_in_responsive_adaptative.ui.theme.Black100
import com.example.sign_in_responsive_adaptative.ui.theme.Gray100
import com.example.sign_in_responsive_adaptative.ui.theme.Red50
import com.example.sign_in_responsive_adaptative.ui.theme.TextFieldStyles
import com.example.sign_in_responsive_adaptative.R
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel

@Composable
fun ValidatedPasswordField(
    viewModel: MainViewModel = viewModel(),
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Placeholder...",
    assistiveText: String = "Assistive text",
    regex: Regex,
    visibilityIconRes: Int, // ID del icono de ojo abierto (visible)
    visibilityOffIconRes: Int, // ID del icono de ojo cerrado (no visible)
    id: String,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }
    val isValid = value.isEmpty() || regex.matches(value)
    val textColor = if (isValid) Black100 else Red50
    val assistiveColor = if (isValid) Gray100 else Red50
    viewModel.textValid(id, isValid)
    Column(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextFieldStyles.inputText.copy(color = textColor),
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            if (value.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    style = TextFieldStyles.placeholder
                                )
                            }
                            innerTextField()
                        }

                        IconButton(
                            onClick = { passwordVisible = !passwordVisible }
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = if (passwordVisible)
                                        visibilityIconRes
                                    else
                                        visibilityOffIconRes
                                ),
                                contentDescription = if (passwordVisible)
                                    "Ocultar contraseña"
                                else
                                    "Mostrar contraseña",
                                tint = Black100,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }

                    Divider(
                        color = if (isValid) Black100 else Red50,
                        thickness = 1.dp
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = assistiveText,
            style = TextFieldStyles.assistiveText.copy(color = assistiveColor)
        )
    }
}