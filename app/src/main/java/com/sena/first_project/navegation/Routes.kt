package com.sena.first_project.navegation

import kotlinx.serialization.Serializable

// P1: Bienvenida
@Serializable
data object RutaInicio

// P2: Lista libros
@Serializable
data object RutaListaLibros

// P3: Detalle libro
@Serializable
data class RutaDetalleLibro(
    val nombreLibro: String,
    val autor: String,
    val categoria: String,
    val descripcion: String
)

// P4: Confirmación reserva
@Serializable
data class RutaConfirmacionReserva(
    val nombreLibro: String,
    val fecha: String
)

// P8: Éxito reserva
@Serializable
data class RutaRenovacionExitosa(
    val nombreLibro: String,
    val fechaNueva: String
)