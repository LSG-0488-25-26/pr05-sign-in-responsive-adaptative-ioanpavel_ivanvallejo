package com.example.sign_in_responsive_adaptative.view


import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sign_in_responsive_adaptative.model.WindowSizeClass
import com.example.sign_in_responsive_adaptative.ui.theme.Black100
import com.example.sign_in_responsive_adaptative.ui.theme.Gray100
import com.example.sign_in_responsive_adaptative.ui.theme.Red50
import com.example.sign_in_responsive_adaptative.ui.theme.TextFieldStyles
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel
import com.example.sign_in_responsive_adaptative.viewModel.getAdaptiveDimensions
import com.example.sign_in_responsive_adaptative.viewModel.rememberWindowSize

@Composable
fun StandartTextField(
    viewModel: MainViewModel = viewModel(),
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Placeholder...",
    assistiveText: String = "Assistive text",
    regex: Regex,
    id: String,
    modifier: Modifier = Modifier
) {
    val windowSize = rememberWindowSize()
    val dimensions = getAdaptiveDimensions(windowSize)

    val isValid = value.isEmpty() || regex.matches(value)
    val textColor = if (isValid) Black100 else Red50
    val assistiveColor = if (isValid) Gray100 else Red50

    viewModel.textValid(id, isValid)

    Column(
        modifier = modifier.widthIn(max = dimensions.fieldWidth)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextFieldStyles.inputText.copy(
                color = textColor,
                fontSize = when (windowSize.width) {
                    WindowSizeClass.COMPACT -> 14.sp
                    WindowSizeClass.MEDIUM -> 16.sp
                    WindowSizeClass.EXPANDED -> 18.sp
                }
            ),
            decorationBox = { innerTextField ->
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = dimensions.verticalPadding,
                                horizontal = dimensions.horizontalPadding
                            )
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextFieldStyles.placeholder.copy(
                                    fontSize = when (windowSize.width) {
                                        WindowSizeClass.COMPACT -> 14.sp
                                        WindowSizeClass.MEDIUM -> 16.sp
                                        WindowSizeClass.EXPANDED -> 18.sp
                                    }
                                )
                            )
                        }
                        innerTextField()
                    }

                    Divider(
                        color = if (isValid) Black100 else Red50,
                        thickness = dimensions.dividerThickness
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = assistiveText,
            style = TextFieldStyles.assistiveText.copy(
                color = assistiveColor,
                fontSize = when (windowSize.width) {
                    WindowSizeClass.COMPACT -> 12.sp
                    WindowSizeClass.MEDIUM -> 13.sp
                    WindowSizeClass.EXPANDED -> 14.sp
                }
            ),
            modifier = Modifier.padding(horizontal = dimensions.horizontalPadding)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun TextfieldPreview() {
    var aux by remember {mutableStateOf("")}
    StandartTextField(
        value = aux,
        onValueChange = { aux = it },
        placeholder = "prueba",
        assistiveText = "claramente esto es una prueba",
        regex = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"),
        id = "snn",
        modifier = Modifier.width(200.dp)
    )
}