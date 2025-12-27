package com.example.sign_in_responsive_adaptative.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.sign_in_responsive_adaptative.model.AdaptiveDimensions
import com.example.sign_in_responsive_adaptative.model.WindowSize
import com.example.sign_in_responsive_adaptative.model.WindowSizeClass

@Composable
fun getAdaptiveDimensions(windowSize: WindowSize): AdaptiveDimensions {
    return when (windowSize.width) {
        WindowSizeClass.COMPACT -> AdaptiveDimensions(
            fieldWidth = 280.dp,
            iconSize = 24.dp,
            verticalPadding = 8.dp,
            horizontalPadding = 12.dp,
            dividerThickness = 1.dp
        )
        WindowSizeClass.MEDIUM -> AdaptiveDimensions(
            fieldWidth = 400.dp,
            iconSize = 28.dp,
            verticalPadding = 12.dp,
            horizontalPadding = 16.dp,
            dividerThickness = 1.5.dp
        )
        WindowSizeClass.EXPANDED -> AdaptiveDimensions(
            fieldWidth = 500.dp,
            iconSize = 32.dp,
            verticalPadding = 14.dp,
            horizontalPadding = 20.dp,
            dividerThickness = 2.dp
        )
    }
}