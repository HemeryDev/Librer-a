package com.sena.first_project

data class Libro(
    val nombre: String,
    val autor: String,
    val categoria: String,
    val descripcion: String
)

object RepositorioLibros {
    val listaLibros = listOf(
        Libro(
            nombre = "Clean Code",
            autor = "Robert C. Martin",
            categoria = "Programación",
            descripcion = "Guía práctica para escribir código limpio, legible y mantenible. Un clásico imprescindible para desarrolladores."
        ),
        Libro(
            nombre = "Kotlin para Android",
            autor = "Varios Autores",
            categoria = "Móvil",
            descripcion = "Aprende el desarrollo moderno de aplicaciones Android con Kotlin de forma práctica y sencilla."
        ),
        Libro(
            nombre = "Arquitectura de Software",
            autor = "Varios Autores",
            categoria = "Arquitectura",
            descripcion = "Conceptos fundamentales y patrones de diseño para estructurar proyectos escalables."
        ),
        Libro(
            nombre = "Jetpack Compose",
            autor = "Google",
            categoria = "UI/UX",
            descripcion = "Aprende a diseñar interfaces declarativas nativas en Android con Jetpack Compose."
        )
    )
}