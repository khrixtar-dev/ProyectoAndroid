package com.example.proyectobase.API

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * --------------------------------------------------------------
 * Clase que actúa como repositorio para manejar la conexión entre
 * la aplicación y el web service (API).
 *
 * Utiliza corrutinas para realizar las llamadas de red en un hilo
 * de fondo (IO), evitando bloquear el hilo principal (UI).
 * --------------------------------------------------------------
 */
object RegionComunaRepository {

    /**
     * ----------------------------------------------------------
     * Función suspendida que obtiene la lista de regiones y comunas
     * desde el API.
     *
     * - Ejecuta la llamada dentro del contexto IO (hilo de fondo)
     * - Envuelve el resultado en un objeto Result para manejar
     *   éxito o error de forma segura.
     *
     * Retorna:
     * - Result.success con la lista de RegionComuna en caso de éxito
     * - Result.failure con la excepción en caso de error
     * ----------------------------------------------------------
     */
    suspend fun fetchRegionComuna(): Result<List<RegionComuna>> = withContext(Dispatchers.IO) {
        try {
            // Llama al servicio Retrofit para obtener la lista
            Result.success(ApiDuocRegionComuna.service.getRegionComuna())
        } catch (e: Exception) {
            // Captura cualquier excepción y la envuelve en un Result.failure
            Result.failure(e)
        }
    }
}
