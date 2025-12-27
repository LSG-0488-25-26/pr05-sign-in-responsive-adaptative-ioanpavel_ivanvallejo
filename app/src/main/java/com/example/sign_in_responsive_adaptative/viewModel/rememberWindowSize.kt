package com.example.sign_in_responsive_adaptative.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.sign_in_responsive_adaptative.model.WindowSize
import com.example.sign_in_responsive_adaptative.model.WindowSizeClass

@Composable
fun rememberWindowSize(): WindowSize {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    return WindowSize(
        width = when {
            screenWidth < 600.dp -> WindowSizeClass.COMPACT
            screenWidth < 840.dp -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        },
        height = when {
            screenHeight < 480.dp -> WindowSizeClass.COMPACT
            screenHeight < 900.dp -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }
    )
}