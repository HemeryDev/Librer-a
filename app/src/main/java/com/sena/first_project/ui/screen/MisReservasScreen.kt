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
fun MisReservasScreen(
    onVerReserva: (String, String, String) -> Unit,
    onVolverInicio: () -> Unit
) {
    val libroFijo = "Clean Code"
    val fechaFija = "15-06-2026"
    val codigoFijo = "RES-2026-001"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        Text(
            text = "Mis Reservas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A)
        )
        Text(
            text = "📚 Lista de reservas activas",
            fontSize = 13.sp,
            color = Color(0xFF64748B)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC)),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .width(50.dp)
                            .height(70.dp)
                            .background(Color(0xFF0F172A), RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Clean\nCode",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Libro: $libroFijo",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "Fecha: $fechaFija",
                            color = Color(0xFF64748B),
                            fontSize = 13.sp
                        )
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xFFDCFCE7),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                text = "Activa",
                                color = Color(0xFF16A34A),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                BotonGeneral(
                    texto = "👁 Ver Reserva",
                    colorFondo = Color(0xFF4F46E5),
                    onClick = { onVerReserva(libroFijo, fechaFija, codigoFijo) }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = onVolverInicio,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("← Volver al Inicio", color = Color(0xFF64748B))
        }
    }
}