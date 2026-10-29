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

// Pantalla 3: Detalle del libro (recibe el nombre del libro seleccionado)
@Serializable
data class RutaDetalleLibro(
    val nombreLibro: String
)

// Pantalla 4: Confirmación de reserva exitosa inicial
@Serializable
data class RutaConfirmacionReserva(
    val nombreLibro: String,
    val fecha: String
)

// ==========================================
// FLUJO 2: MIS RESERVAS Y RENOVACIÓN
// ==========================================

// Pantalla 5: Lista de reservas activas
@Serializable
data object RutaMisReservas

// Pantalla 6: Detalle de la reserva (viajan los 3 parámetros de la práctica)
@Serializable
data class RutaDetalleReserva(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String
)

// Pantalla 7: Pantalla para ingresar la nueva fecha de renovación
@Serializable
data class RutaRenovarReserva(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String
)

// Pantalla 8: Éxito final de la renovación de reserva
@Serializable
data class RutaRenovacionExitosa(
    val nombreLibro: String,
    val fechaNueva: String
)