package com.example.sign_in_responsive_adaptative.model

enum class WindowSizeClass {
    COMPACT,
    MEDIUM,
    EXPANDED
}
data class WindowSize(
    val width: WindowSizeClass,
    val height: WindowSizeClass
)