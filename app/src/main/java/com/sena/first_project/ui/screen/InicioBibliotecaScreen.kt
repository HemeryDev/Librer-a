package com.sena.first_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.first_project.ui.components.BotonGeneral

@Composable
fun InicioBibliotecaScreen(
    onNavegarLista: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "📚",
            fontSize = 60.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¡Bienvenido a tu Biblioteca!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Descubre, aprende y reserva tus libros favoritos.",
            fontSize = 14.sp,
            color = Color(0xFF64748B)
        )
        Spacer(modifier = Modifier.height(32.dp))
        BotonGeneral(
            texto = "Ver Libros",
            colorFondo = Color(0xFF4F46E5),
            onClick = onNavegarLista
        )
    }
}