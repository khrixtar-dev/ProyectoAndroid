package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Import del package custom llamado utils
import com.example.proyectobase.utils.OpMatematicas

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val txTituloCalculadora : TextView = findViewById(R.id.txTituloCalculadora)
        val edNumero1 : EditText = findViewById(R.id.edNumero1)
        val edNumero2 : EditText = findViewById(R.id.edNumero2)
        val txResultado : TextView =findViewById(R.id.txResultado)
        var spSeleccionarOperacion : Spinner = findViewById(R.id.spSeleccionarOperacion)
        val btnCalcular : Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            var calcN1 : Int = edNumero1.text.toString().toIntOrNull()?:0
            var calcN2 : Int = edNumero2.text.toString().toIntOrNull()?:0

            var resultadoOP : Int = OpMatematicas.sumar(calcN1,calcN2)

            txResultado.text = resultadoOP.toString()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}