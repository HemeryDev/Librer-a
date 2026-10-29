package com.sena.first_project.ui.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sena.first_project.ui.components.CardLibro

// Clase de apoyo interna local para la vista
data class ItemLibro(
    val nombre: String,
    val autor: String,
    val categoria: String,
    val descripcion: String
)

@Composable
fun CatalogoSection(
    onSeleccionarLibro: (ItemLibro) -> Unit
) {
    // Lista estática local del catálogo
    val libros = listOf(
        ItemLibro(
            nombre = "Clean Code",
            autor = "Robert C. Martin",
            categoria = "Programación",
            descripcion = "Guía práctica para escribir código limpio, legible y mantenible. Un clásico imprescindible para desarrolladores."
        ),
        ItemLibro(
            nombre = "Kotlin para Android",
            autor = "JetBrains Team",
            categoria = "Móviles",
            descripcion = "Aprende los fundamentos y mejores prácticas del desarrollo nativo en Android utilizando Kotlin."
        ),
        ItemLibro(
            nombre = "Arquitectura de Software",
            autor = "Martin Fowler",
            categoria = "Arquitectura",
            descripcion = "Patrones de diseño, separación de responsabilidades y modularidad en sistemas empresariales."
        ),
        ItemLibro(
            nombre = "Jetpack Compose",
            autor = "Google Developers",
            categoria = "UI Reactiva",
            descripcion = "Diseño declarativo de interfaces de usuario modernas y dinámicas para el sistema operativo Android."
        )
    )

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(libros) { libro ->
            CardLibro(
                nombre = libro.nombre,
                autor = libro.autor,
                onVerDetalle = { onSeleccionarLibro(libro) }
            )
        }
    }
}