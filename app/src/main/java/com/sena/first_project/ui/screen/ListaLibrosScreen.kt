package com.sena.first_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListaLibrosScreen(
    onNavegarDetalle: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Mis Libros",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
        )
        Text(
            text = "Elige un libro para ver más detalles.",
            fontSize = 13.sp,
            color = Color(0xFF64748B)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Consumo de la sección creada en el Paso 4
        CatalogoSection(
            libros = RepositorioLibros.listaLibros,
            onSeleccionarLibro = { nombre -> onNavegarDetalle(nombre) }
        )
    }
}