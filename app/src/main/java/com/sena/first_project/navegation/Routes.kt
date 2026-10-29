package com.sena.first_project.navegation

import kotlinx.serialization.Serializable

// ==========================================
// FLUJO 1: CATÁLOGO Y RESERVA DE LIBROS
// ==========================================

// Pantalla 1: Bienvenida
@Serializable
data object RutaInicio

// Pantalla 2: Lista de libros disponibles
@Serializable
data object RutaListaLibros

// Pantalla 3: Detalle del libro (pasa los datos del libro seleccionado)
@Serializable
data class RutaDetalleLibro(
    val nombreLibro: String,
    val autor: String,
    val categoria: String,
    val descripcion: String
)

// Pantalla 4: Confirmación de reserva
@Serializable
data class RutaConfirmacionReserva(
    val nombreLibro: String,
    val fecha: String
)

// Pantalla 8: Éxito final de la renovación de reserva
@Serializable
data class RutaRenovacionExitosa(
    val nombreLibro: String,
    val fechaNueva: String
)