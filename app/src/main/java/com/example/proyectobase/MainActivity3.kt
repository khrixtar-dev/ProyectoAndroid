package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val txFormNombre : EditText = findViewById(R.id.txFormNombre)
        val txFormTelefono : EditText = findViewById(R.id.txFormTelefono)
        val txFormFechaNacimiento : EditText = findViewById(R.id.txFormFechaNacimiento)
        val btnRegistrar : Button = findViewById(R.id.btnRegistrar)


        btnRegistrar.setOnClickListener {
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(this,"Registro de "+ txFormNombre.text.toString() + " completado", duration)
            toast.show()
            val toast2 = Toast.makeText(this,txFormTelefono.text.toString(),duration)
            toast2.show()
            val toast3 = Toast.makeText(this,txFormFechaNacimiento.text.toString(),duration)
            toast3.show()


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}