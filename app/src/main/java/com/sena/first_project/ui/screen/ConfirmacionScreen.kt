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
import com.sena.first_project.ui.components.BotonGeneral

@Composable
fun ConfirmacionScreen(
    nombreLibro: String,
    fecha: String,
    onVolverInicio: () -> Unit,
    onIrAMisReservas: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("✔", fontSize = 60.sp, color = Color(0xFF16A34A))
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Reserva Exitosa",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF16A34A)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Libro: $nombreLibro", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Fecha: $fecha", color = Color(0xFF64748B))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        BotonGeneral(
            texto = "Volver al Inicio",
            colorFondo = Color(0xFF16A34A),
            onClick = onVolverInicio
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onIrAMisReservas,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Ir a Mis Reservas →", fontWeight = FontWeight.Bold)
        }
    }
}