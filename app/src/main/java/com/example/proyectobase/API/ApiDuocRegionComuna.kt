package com.example.proyectobase.API

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object ApiDuocRegionComuna {

    // --------------------------------------------------------------
    // URL base de la API REST. Aquí defines el entorno de ejecución:
    // puede ser desarrollo, certificación o producción.
    // En este caso, apunta a https://uxdynamic.cl/
    // --------------------------------------------------------------
    private const val BASE_URL = "https://uxdynamic.cl/"

    // --------------------------------------------------------------
    // Configura un interceptor para mostrar logs completos (BODY)
    // de las peticiones y respuestas HTTP. Muy útil para debug.
    // --------------------------------------------------------------
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // --------------------------------------------------------------
    // Construye un cliente HTTP OkHttp agregando el interceptor
    // para registrar el tráfico HTTP.
    // --------------------------------------------------------------
    private val http = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    // --------------------------------------------------------------
    // Configura Moshi como convertidor JSON <-> Objetos Kotlin,
    // con soporte para características de Kotlin (data classes, etc).
    // --------------------------------------------------------------
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // --------------------------------------------------------------
    // Construye el cliente Retrofit usando:
    // - la URL base de la API
    // - el cliente OkHttp con logging
    // - el convertidor Moshi para manejar JSON
    // Luego crea una instancia de la interfaz que define los
    // endpoints (ApiRegionComunaServicio).
    // --------------------------------------------------------------
    val service: ApiRegionComunaServicio by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(http)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiRegionComunaServicio::class.java)
    }
}