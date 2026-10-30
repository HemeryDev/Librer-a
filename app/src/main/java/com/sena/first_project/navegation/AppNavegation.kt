package com.sena.first_project.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sena.first_project.ui.screen.*

@Composable
fun AppNavegation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RutaInicio
    ) {
        // --- FLUJO 1: BIBLIOTECA ---
        composable<RutaInicio> {
            InicioBibliotecaScreen(
                onNavegarLista = { navController.navigate(RutaListaLibros) }
            )
        }

        composable<RutaListaLibros> {
            ListaLibrosScreen(
                onNavegarDetalle = { nombre ->
                    navController.navigate(RutaDetalleLibro(nombreLibro = nombre))
                }
            )
        }

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

        composable<RutaConfirmacionReserva> { backStackEntry ->
            val ruta: RutaConfirmacionReserva = backStackEntry.toRoute()
            ConfirmacionScreen(
                nombreLibro = ruta.nombreLibro,
                fecha = ruta.fecha,
                onVolverInicio = {
                    navController.navigate(RutaInicio) {
                        popUpTo<RutaInicio> { inclusive = false }
                        launchSingleTop = true
                    }
                },
                onIrAMisReservas = {
                    navController.navigate(RutaMisReservas)
                }
            )
        }

        // --- FLUJO 2: MIS RESERVAS ---
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
                onVolverInicio = {
                    navController.navigate(RutaInicio) {
                        popUpTo<RutaInicio> { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }

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
                onCancelarReserva = { navController.popBackStack() },
                onVolver = { navController.popBackStack() }
            )
        }

        composable<RutaRenovarReserva> { backStackEntry ->
            val ruta: RutaRenovarReserva = backStackEntry.toRoute()
            RenovarReservaScreen(
                nombreLibro = ruta.nombreLibro,
                fechaActual = ruta.fechaReserva,
                onConfirmarRenovacion = { fechaNueva ->
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

        composable<RutaRenovacionExitosa> { backStackEntry ->
            val ruta: RutaRenovacionExitosa = backStackEntry.toRoute()
            RenovacionExitosaScreen(
                nombreLibro = ruta.nombreLibro,
                fechaNueva = ruta.fechaNueva,
                onVolverMisReservas = {
                    navController.navigate(RutaMisReservas) {
                        popUpTo<RutaMisReservas> { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}