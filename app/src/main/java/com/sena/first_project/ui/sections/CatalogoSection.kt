package com.sena.first_project.ui.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sena.first_project.data.model.Libro
import com.sena.first_project.ui.components.CardLibro

@Composable
fun CatalogoSection(
    libros: List<Libro>,
    onSeleccionarLibro: (String) -> Unit
) {
    // LazyColumn: contenedor de alto rendimiento para listas dinámicas
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Bloque items: itera de forma eficiente sobre la colección de libros
        items(libros) { libro ->
            CardLibro(
                libro = libro,
                onVerDetalle = { onSeleccionarLibro(libro.nombre) }
            )
        }
    }
}