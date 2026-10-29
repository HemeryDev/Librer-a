package com.sena.first_project.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.first_project.ui.components.BotonGeneral

@Composable
fun RenovarReservaScreen(
    nombreLibro: String,
    fechaActual: String,
    onConfirmarRenovacion: (String) -> Unit,
    onVolver: () -> Unit
) {
    // Estado reactivo que almacena la nueva fecha
    var nuevaFecha by remember { mutableStateOf("30/06/2026") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onVolver) {
                Text("←", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                text = "Renovar Reserva",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Libro: $nombreLibro", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "📅 Reserva Actual: $fechaActual", color = Color(0xFF64748B), fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Nueva Fecha:", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(6.dp))

        // Campo reactivo: value lee y onValueChange muta el estado
        OutlinedTextField(
            value = nuevaFecha,
            onValueChange = { nuevoValor -> nuevaFecha = nuevoValor },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.weight(1f))

        BotonGeneral(
            texto = "✔ Confirmar Renovación",
            colorFondo = Color(0xFFEA580C),
            onClick = { onConfirmarRenovacion(nuevaFecha) }
        )
    }
}
