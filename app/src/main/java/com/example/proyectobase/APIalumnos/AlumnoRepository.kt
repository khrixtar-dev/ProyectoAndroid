package com.example.proyectobase.APIalumnos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AlumnoRepository {


    suspend fun fetchAlumnos(): Result<List<Alumno>> = withContext(Dispatchers.IO){
        try {
            Result.success(ApiDuocClient.service.getAlumnos())
        } catch (e: Exception){
            Result.failure(e)
        }
    }


    suspend fun insertAlumno(request: AlumnoInsertRequest):Result<InsertResponse> = withContext(Dispatchers.IO){
        try {
            Result.success(ApiDuocClient.service.insertAlumno(request))
        } catch (e : Exception){
            Result.failure(e)
        }
    }

}