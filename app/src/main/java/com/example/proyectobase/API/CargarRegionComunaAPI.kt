package com.example.proyectobase.API

import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


object CargarRegionComunaAPI {

    /** Carga REGION COMUNA del API y los pinta en el spinner indicado. */
    fun CargarRegionComunaAPI(owner: LifecycleOwner, spinner: Spinner) {
        owner.lifecycleScope.launch {
            val res = RegionComunaRepository.fetchRegionComuna()

            res.onSuccess { regionComuna ->
                if (regionComuna.isEmpty()) {
                    Toast.makeText(
                        spinner.context,
                        "Sin datos desde el servicio",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                val datosRegion = regionComuna.map { a ->
                    "${a.region}\n" }


                spinner.adapter = ArrayAdapter(
                    spinner.context,
                    android.R.layout.simple_list_item_1,
                    datosRegion.distinct() //Filtra por regiones unicas
                )



                android.util.Log.d("WS_REGIONCOMUNA", "items=${regionComuna.size}")
            }.onFailure { e ->
                android.util.Log.e("WS_REGIONCOMUNA_ERR", "falló", e)
                Toast.makeText(
                    spinner.context,
                    "Error al cargar: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    /** Carga region comuna del API y los pinta en el spinner indicado. */
    fun cargarRegionComuna2(owner: LifecycleOwner, spinner: Spinner, regionSeleccionada : String) {
        owner.lifecycleScope.launch {
            val res = RegionComunaRepository.fetchRegionComuna()

            res.onSuccess { regionComuna ->
                if (regionComuna.isEmpty()) {
                    Toast.makeText(
                        spinner.context,
                        "Sin datos desde el servicio",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                val datos = regionComuna.map { a ->
                    if (a.region == regionSeleccionada){
                        "${a.comuna}\n"
                    }
                }




                spinner.adapter = ArrayAdapter(
                    spinner.context,
                    android.R.layout.simple_list_item_1,
                    datos
                )

                android.util.Log.d("ws_region_comuna", "items=${regionComuna.size}")

            }.onFailure { e ->
                android.util.Log.e("ws_region_comuna", "falló", e)
                Toast.makeText(
                    spinner.context,
                    "Error al cargar: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}