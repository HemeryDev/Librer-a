package com.sena.first_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sena.first_project.navegation.AppNavegation
import com.sena.first_project.ui.theme.First_projectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            First_projectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Punto de entrada: monta el enrutador de la biblioteca
                    AppNavegation()
                }
            }
        }
    }
}