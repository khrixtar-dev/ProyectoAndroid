package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectobase.API.CargarRegionComunaAPI

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)

        val txtTituloRegion : TextView = findViewById(R.id.txtTituloRegion)
        val spRegion : Spinner = findViewById(R.id.spRegion)
        val txtTituloComuna : TextView = findViewById(R.id.txtTituloComuna)
        val spComuna : Spinner = findViewById(R.id.spComuna)
        val btnConfirmar : Button = findViewById(R.id.btnConfirmar)

        CargarRegionComunaAPI.CargarRegionComunaAPI(this, spRegion)

        val regionSeleccionada: String = spRegion.selectedItem?.toString() ?: "Sin selección"



        CargarRegionComunaAPI.cargarRegionComuna2(this, spComuna, regionSeleccionada)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}