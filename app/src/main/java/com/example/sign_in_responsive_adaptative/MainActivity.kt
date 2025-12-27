package com.example.sign_in_responsive_adaptative


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.sign_in_responsive_adaptative.ui.theme.Sign_in_responsive_adaptativeTheme
import com.example.sign_in_responsive_adaptative.view.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sign_in_responsive_adaptativeTheme {
                AppNavHost()
            }
        }
    }
}

