package com.sena.first_project.navegation

import kotlinx.serialization.Serializable

// Rutas Flujo 1
@Serializable
object RutaInicio

@Serializable
object RutaListaLibros

@Serializable
data class RutaDetalleLibro(
    val nombreLibro: String
)

@Serializable
data class RutaConfirmacionReserva(
    val nombreLibro: String,
    val fecha: String
)

// Rutas Flujo 2
@Serializable
object RutaMisReservas

@Serializable
data class RutaDetalleReserva(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String
)

@Serializable
data class RutaRenovarReserva(
    val nombreLibro: String,
    val fechaReserva: String,
    val codigoReserva: String
)

@Serializable
data class RutaRenovacionExitosa(
    val nombreLibro: String,
    val fechaNueva: String
)