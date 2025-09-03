package com.example.proyectobase.API

/**
 * --------------------------------------------------------------
 * Data class en Kotlin, utilizada para representar datos de manera simple.
 * Esta clase automáticamente genera funciones útiles como:
 * - toString(): para imprimir su contenido
 * - equals(): para comparar objetos
 * - copy(): para crear copias con modificaciones
 * - componentN(): para destructuring declarations
 *
 * En este caso, representa una entidad "RegionComuna" con:
 * - id: identificador numérico
 * - comuna: nombre de la comuna
 * - region: nombre de la región
 *
 * Las líneas comentadas indican campos que podrían agregarse en el futuro.
 * --------------------------------------------------------------
 */
data class RegionComuna(
    val id: Int,
    val comuna: String,
    val region: String
    //val grupo: String,
    //val seccion: String
)
