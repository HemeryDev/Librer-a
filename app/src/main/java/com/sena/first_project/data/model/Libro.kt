package com.sena.first_project.data.model

import androidx.compose.runtime.mutableStateListOf

// Molde de la reserva
data class ReservaActiva(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String,
    val autor: String
)

data class Libro(
    val id: Int,
    val nombre: String,
    val autor: String,
    val categoria: String,
    val descripcion: String
)

object RepositorioLibros {
    // Catálogo general de libros
    val listaLibros: List<Libro> = listOf(
        Libro(
            id = 1,
            nombre = "Clean Code",
            autor = "Robert C. Martin",
            categoria = "Programación",
            descripcion = "Guía práctica para escribir código limpio, legible y mantenible. Un clásico imprescindible para desarrolladores."
        ),
        Libro(
            id = 2,
            nombre = "Kotlin para Android",
            autor = "JetBrains Team",
            categoria = "Móviles",
            descripcion = "Aprende los fundamentos y mejores prácticas del desarrollo nativo en Android utilizando Kotlin."
        ),
        Libro(
            id = 3,
            nombre = "Arquitectura de Software",
            autor = "Martin Fowler",
            categoria = "Arquitectura",
            descripcion = "Patrones de diseño, separación de responsabilidades y modularidad en sistemas empresariales."
        ),
        Libro(
            id = 4,
            nombre = "Jetpack Compose",
            autor = "Google Developers",
            categoria = "UI Reactiva",
            descripcion = "Diseño declarativo de interfaces de usuario modernas y dinámicas para el sistema operativo Android."
        )
    )

    // Lista mutable y reactiva de reservas activas
    val listaReservas = mutableStateListOf(
        ReservaActiva(
            nombreLibro = "Clean Code",
            fechaReserva = "15/06/2026",
            codigoReserva = "RES-2026-001",
            autor = "Robert C. Martin"
        )
    )

    fun agregarReserva(nombreLibro: String, fecha: String) {
        val libro = listaLibros.find { it.nombre == nombreLibro }
        val nuevoCodigo = "RES-2026-00${listaReservas.size + 1}"
        // Si no está ya reservado, lo agregamos al principio de la lista
        if (listaReservas.none { it.nombreLibro == nombreLibro }) {
            listaReservas.add(
                0,
                ReservaActiva(
                    nombreLibro = nombreLibro,
                    fechaReserva = fecha,
                    codigoReserva = nuevoCodigo,
                    autor = libro?.autor ?: "Autor Desconocido"
                )
            )
        }
    }

    fun cancelarReserva(codigoReserva: String) {
        listaReservas.removeAll { it.codigoReserva == codigoReserva }
    }

    fun renovarFecha(codigoReserva: String, nuevaFecha: String) {
        val index = listaReservas.indexOfFirst { it.codigoReserva == codigoReserva }
        if (index != -1) {
            val actual = listaReservas[index]
            listaReservas[index] = actual.copy(fechaReserva = nuevaFecha)
        }
    }
}