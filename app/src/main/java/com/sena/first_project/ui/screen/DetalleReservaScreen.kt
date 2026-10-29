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

@Composable
fun DetalleReservaScreen(
    nombreLibro: String,
    fechaReserva: String,
    codigoReserva: String,
    onRenovar: () -> Unit,
    onCancelarReserva: () -> Unit,
    onVolver: () -> Unit
) {
    val libro = RepositorioLibros.listaLibros.find { it.nombre == nombreLibro }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding() // Corregido: Eleva los botones para que la barra del celular no los tape
            .padding(18.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onVolver) {
                Text("←", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
            Text(
                text = "Detalle de Reserva",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
            )
        }

        Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFFDCFCE7),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "✔ Argumentos recibidos correctamente",
                color = Color(0xFF16A34A),
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Nombre: $nombreLibro", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Autor: ${libro?.autor ?: "Desconocido"}", color = Color(0xFF64748B), fontSize = 13.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Fecha Reserva: $fechaReserva", fontSize = 14.sp)
                Text(
                    text = "Código Reserva: $codigoReserva",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFFD97706)
                )
                Text(
                    text = "Estado: Activa",
                    color = Color(0xFF16A34A),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = onRenovar,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("🔄 Renovar", fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = {
                    RepositorioLibros.cancelarReserva(codigoReserva)
                    onCancelarReserva()
                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("✖ Cancelar", fontWeight = FontWeight.Bold)
            }
        }
    }
}