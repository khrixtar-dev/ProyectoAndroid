package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        var txtNombre : EditText = findViewById(R.id.txtNombre)
        var txtApellido : EditText = findViewById(R.id.txtApellido)
        val spGrupo : Spinner = findViewById(R.id.spGrupo)
        val spSeccion : Spinner = findViewById(R.id.spSeccion)
        val btnGuardar : Button = findViewById(R.id.btnGuardar)
        val btnTomarFoto : Button = findViewById(R.id.btnTomarFoto)

        //lista para spinner grupos
        val grupos = listOf(
            "1"
            , "2"
            , "3"
            , "4"
            , "5"
            , "6"
            , "7"
            , "8"
            , "9"
            , "10"
            , "11"
            , "12"
            , "13"
            , "14"
            , "15"
        )

        val seccionesN = listOf("001D"
            ,"002D"
            ,"003D"
            ,"004D"
            ,"005D"
            , "006D"
            , "007D"
            , "008D"
            , "009D"
            , "010D")

        val adapter = ArrayAdapter(
            this
            , android.R.layout.simple_spinner_item, grupos).apply()
        {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        val adapter2 = ArrayAdapter(
            this
            , android.R.layout.simple_spinner_item, seccionesN).apply()
        {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }


        spGrupo.adapter = adapter

        spSeccion.adapter = adapter2


        btnGuardar.setOnClickListener {
            txtNombre.setText("")
            txtApellido.setText("")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}