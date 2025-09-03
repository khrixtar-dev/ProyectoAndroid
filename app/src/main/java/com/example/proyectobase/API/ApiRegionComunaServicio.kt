package com.example.proyectobase.API

import retrofit2.http.GET

// --------------------------------------------------------------
// Data class que representa la respuesta de una inserción o
// acción en la API. Contiene:
// - success: indica si la operación fue exitosa (true/false)
// - message: mensaje opcional que puede incluir información o error
// --------------------------------------------------------------
data class InsertResponse(
    val success: Boolean,
    val message: String?
)

// --------------------------------------------------------------
// Interfaz que define los endpoints para Retrofit.
// Aquí defines las llamadas HTTP que puedes hacer a la API.
// --------------------------------------------------------------
interface ApiRegionComunaServicio {

    // ----------------------------------------------------------
    // GET para obtener la lista de regiones y comunas.
    // Llama al endpoint "apiduoc/consulta_comuna.php" en la URL base.
    // Función suspend para usar con corutinas (llamada asíncrona).
    // Retorna una lista de objetos RegionComuna (debe estar definido).
    // ----------------------------------------------------------
    @GET("apiduoc/consulta_comuna.php")
    suspend fun getRegionComuna(): List<RegionComuna>
}
