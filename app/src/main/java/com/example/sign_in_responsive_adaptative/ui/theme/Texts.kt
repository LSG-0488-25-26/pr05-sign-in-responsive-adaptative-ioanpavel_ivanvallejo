package com.example.sign_in_responsive_adaptative.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextFieldStyles {
    private val roboto = FontFamily.SansSerif // Roboto es la fuente Sans Serif por defecto en Android

    // Headers
    val h1 = TextStyle(fontSize = 96.sp, fontWeight = FontWeight.Light, fontFamily = roboto)
    val h2 = TextStyle(fontSize = 60.sp, fontWeight = FontWeight.Light, fontFamily = roboto)
    val h3 = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)
    val h4 = TextStyle(fontSize = 34.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)
    val h5 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)
    val h6 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium, fontFamily = roboto)

    // Body & otros
    val body1 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)
    val body2 = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)
    val button = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium, fontFamily = roboto)
    val caption = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)
    val overline = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal, fontFamily = roboto)

    // Estilos del TextField
    val inputText = body1
    val placeholder = body1.copy(color = GrayLight)
    val assistiveText = caption
}