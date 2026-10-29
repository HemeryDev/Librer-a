package com.sena.first_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.first_project.data.model.RepositorioLibros
import com.sena.first_project.ui.components.BotonGeneral

@Composable
fun DetalleLibroScreen(
    nombreLibro: String,
    onReservar: (String, String) -> Unit,
    onVolver: () -> Unit
) {
    val libro = RepositorioLibros.listaLibros.find { it.nombre == nombreLibro }
        ?: RepositorioLibros.listaLibros.first()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding() // Evita que la barra de estado y navegación tapen la UI
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFFEF3C7),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "📥 Parámetro recibido: $nombreLibro",
                color = Color(0xFFD97706),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }

        Box(
            modifier = Modifier
                .width(130.dp)
                .height(180.dp)
                .background(Color(0xFF0F172A), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = libro.nombre,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Nombre: ${libro.nombre}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "Autor: ${libro.autor}", color = Color(0xFF475569), fontSize = 14.sp)
            Text(text = "Categoría: ${libro.categoria}", color = Color(0xFF4F46E5), fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Descripción:", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
            Text(text = libro.descripcion, color = Color(0xFF64748B), fontSize = 13.sp)
        }

        Spacer(modifier = Modifier.weight(1f))

        BotonGeneral(
            texto = "Reservar Libro",
            colorFondo = Color(0xFFEA580C),
            onClick = {
                // Guarda la reserva de forma dinámica
                RepositorioLibros.agregarReserva(libro.nombre, "15/06/2026")
                onReservar(libro.nombre, "15/06/2026")
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = onVolver) {
            Text("Volver", color = Color(0xFF64748B))
        }
    }
}