package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ventana_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana2)


        val mensajeBienvenida: TextView = findViewById(R.id.txBienvenido)
        val btnToFormulario : Button = findViewById(R.id.btnToFormulario)

        mensajeBienvenida.text = "Para ingresar al formulario haga click en el boton de abajo"

        btnToFormulario.setOnClickListener {
            val nuevaVentana_2 = Intent(this, MainActivity3::class.java)

            startActivity(nuevaVentana_2)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}