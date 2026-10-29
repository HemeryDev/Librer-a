package com.sena.first_project.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sena.first_project.data.model.RepositorioLibros
import com.sena.first_project.ui.screen.*

@Composable
fun AppNavegation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RutaInicio
    ) {
        // 1. Inicio Biblioteca
        composable<RutaInicio> {
            InicioBibliotecaScreen(
                onNavegarLista = { navController.navigate(RutaListaLibros) },
                onIrMisReservas = { navController.navigate(RutaMisReservas) }
            )
        }

        // 2. Lista de Libros
        composable<RutaListaLibros> {
            ListaLibrosScreen(
                onNavegarDetalle = { nombre ->
                    navController.navigate(RutaDetalleLibro(nombreLibro = nombre))
                }
            )
        }

        // 3. Detalle de Libro
        composable<RutaDetalleLibro> { backStackEntry ->
            val ruta: RutaDetalleLibro = backStackEntry.toRoute()
            DetalleLibroScreen(
                nombreLibro = ruta.nombreLibro,
                onReservar = { nombre, fecha ->
                    navController.navigate(
                        RutaConfirmacionReserva(
                            nombreLibro = nombre,
                            fecha = fecha
                        )
                    )
                },
                onVolver = { navController.popBackStack() }
            )
        }

        // 4. Confirmación de Reserva
        composable<RutaConfirmacionReserva> { backStackEntry ->
            val ruta: RutaConfirmacionReserva = backStackEntry.toRoute()
            ConfirmacionScreen(
                nombreLibro = ruta.nombreLibro,
                fecha = ruta.fecha,
                onVolverInicio = {
                    navController.navigate(RutaInicio) {
                        popUpTo<RutaInicio> { inclusive = true }
                    }
                }
            )
        }

        // 5. Mis Reservas (Muestra reservas activas actualizadas)
        composable<RutaMisReservas> {
            MisReservasScreen(
                onVerReserva = { nombre, fecha, codigo ->
                    navController.navigate(
                        RutaDetalleReserva(
                            nombreLibro = nombre,
                            fechaReserva = fecha,
                            codigoReserva = codigo
                        )
                    )
                },
                onVolverInicio = { navController.popBackStack() }
            )
        }

        // 6. Detalle de Reserva
        composable<RutaDetalleReserva> { backStackEntry ->
            val ruta: RutaDetalleReserva = backStackEntry.toRoute()
            DetalleReservaScreen(
                nombreLibro = ruta.nombreLibro,
                fechaReserva = ruta.fechaReserva,
                codigoReserva = ruta.codigoReserva,
                onRenovar = {
                    navController.navigate(
                        RutaRenovarReserva(
                            nombreLibro = ruta.nombreLibro,
                            fechaReserva = ruta.fechaReserva,
                            codigoReserva = ruta.codigoReserva
                        )
                    )
                },
                onCancelarReserva = {
                    navController.popBackStack()
                },
                onVolver = { navController.popBackStack() }
            )
        }

        // 7. Renovar Reserva
        composable<RutaRenovarReserva> { backStackEntry ->
            val ruta: RutaRenovarReserva = backStackEntry.toRoute()
            RenovarReservaScreen(
                nombreLibro = ruta.nombreLibro,
                fechaActual = ruta.fechaReserva,
                onConfirmarRenovacion = { fechaNueva ->
                    // Actualiza la fecha en la lista
                    RepositorioLibros.renovarFecha(ruta.codigoReserva, fechaNueva)
                    navController.navigate(
                        RutaRenovacionExitosa(
                            nombreLibro = ruta.nombreLibro,
                            fechaNueva = fechaNueva
                        )
                    )
                },
                onVolver = { navController.popBackStack() }
            )
        }

        // 8. Renovación Exitosa
        composable<RutaRenovacionExitosa> { backStackEntry ->
            val ruta: RutaRenovacionExitosa = backStackEntry.toRoute()
            RenovacionExitosaScreen(
                nombreLibro = ruta.nombreLibro,
                fechaNueva = ruta.fechaNueva,
                onVolverMisReservas = {
                    navController.navigate(RutaMisReservas) {
                        popUpTo<RutaMisReservas> { inclusive = true }
                    }
                }
            )
        }
    }
}