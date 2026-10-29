package com.sena.first_project.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Producto(
    onirDetalleProducto: (Int) -> Unit,
    onVolverHome: () -> Unit
){
    var id by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = id,
            onValueChange = {nuevoValor ->
                id = nuevoValor
            }
        )
        Text(
            text = "Hola desde Producto"
        )
        Button(
            onClick = { onirDetalleProducto(id.toInt()) }
        ) {
            Text(
                text = "ir a detalle producto"
            )
        }
        Button(
            onClick = onVolverHome
        ) {
            Text(
                text = "Volver a Home"
            )
        }
    }
}
