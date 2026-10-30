package com.sena.first_project.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.first_project.Libro
import com.sena.first_project.RepositorioLibros
import com.sena.first_project.ui.components.CardLibro

@Composable
fun CatalogoSection(
    onSeleccionarLibro: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(RepositorioLibros.listaLibros) { libro ->
            CardLibro(
                libro = libro,
                onClick = { onSeleccionarLibro(libro.nombre) }
            )
        }
    }
}