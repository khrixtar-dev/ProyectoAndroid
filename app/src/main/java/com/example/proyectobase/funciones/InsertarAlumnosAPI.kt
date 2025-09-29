package com.example.proyectobase.funciones

import android.content.Context
import android.util.Base64
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.proyectobase.APIalumnos.AlumnoInsertRequest
import com.example.proyectobase.APIalumnos.AlumnoRepository
import kotlinx.coroutines.launch

object InsertarAlumnosAPI {

    fun insertarAlumno(
        owner: LifecycleOwner,
        context: Context,
        nombre: String,
        apellido: String,
        grupo: String,
        seccion: String,
        archivoBytes: ByteArray? = null,
        onSuccess: ((String?) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    ) {
        val archivoBase64 = if (archivoBytes != null) {
            Base64.encodeToString(archivoBytes, Base64.NO_WRAP)
        } else {
            Base64.encodeToString("BinarioDeEjemplo".toByteArray(), Base64.NO_WRAP)
        }

        val request = AlumnoInsertRequest(
            nombre = nombre.trim(),
            apellido = apellido.trim(),
            grupo = grupo.trim(),
            seccion = seccion.trim(),
            archivo = archivoBase64
        )

        owner.lifecycleScope.launch {
            val res = AlumnoRepository.insertAlumno(request)
            res.onSuccess { r ->
                Toast.makeText(context, r.message?: "Insert OK", Toast.LENGTH_LONG).show()
                onSuccess?.invoke(r.message)
            }.onFailure { e ->
                Toast.makeText(context, "Error insertando: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

    }

}