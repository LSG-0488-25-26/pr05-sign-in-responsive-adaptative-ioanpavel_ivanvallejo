package com.example.sign_in_responsive_adaptative


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sign_in_responsive_adaptative.ui.theme.Sign_in_responsive_adaptativeTheme
import com.example.sign_in_responsive_adaptative.view.AppNavHost
import com.example.sign_in_responsive_adaptative.view.Registre

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

