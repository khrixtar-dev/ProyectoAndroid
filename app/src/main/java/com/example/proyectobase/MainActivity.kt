package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // DECLARAMOS VARIABLES CON LOS ELEMENTOS LAYOUT

        val edUsername :EditText = findViewById(R.id.edUsername)
        val edPasswd : EditText = findViewById(R.id.edPasswd)
        val btnLogin : Button = findViewById(R.id.btnLogin)


        val defaultUsr = "correo"
        val defaultPasswd = "clave"

        // LE DAMOS ACCION AL BOTON
        btnLogin.setOnClickListener {
            if (edUsername.text.toString() == defaultUsr &&
                edPasswd.text.toString() == defaultPasswd){
                val toast = Toast.makeText(this,"Ingresando . . .",Toast.LENGTH_SHORT).show()
                val nuevaVentana = Intent(this, MainActivity2::class.java)

                startActivity(nuevaVentana)
            } else {
                val toast = Toast.makeText(this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}