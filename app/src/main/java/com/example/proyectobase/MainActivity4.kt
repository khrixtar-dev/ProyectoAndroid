package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
        val spSeleccionarOperacion : Spinner = findViewById(R.id.spSeleccionarOperacion)
        val btnCalcular : Button = findViewById(R.id.btnCalcular)

        //Crearemos nuestro primer ArrayList
        val menuOperaciones = listOf("Sumar","Restar","Multiplicar","Dividir")

        //Vamos a compeltar el spinner operaciones
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            menuOperaciones
        )

        spSeleccionarOperacion.adapter =  adapter

        btnCalcular.setOnClickListener {
            var calcN1 : Int = edNumero1.text.toString().toIntOrNull()?:0
            var calcN2 : Int = edNumero2.text.toString().toIntOrNull()?:0

            if (spSeleccionarOperacion.selectedItem == "Sumar"){
                var resultadoOP : Int = OpMatematicas.sumar(calcN1,calcN2)

                txResultado.text = "El resultado es: " + resultadoOP.toString()
            }
            else if (spSeleccionarOperacion.selectedItem == "Restar"){
                var resultadoOP : Int = OpMatematicas.restar(calcN1,calcN2)

                txResultado.text = "El resultado es: " + resultadoOP.toString()
            }
            else if (spSeleccionarOperacion.selectedItem == "Multiplicar"){
                var resultadoOP : Int = OpMatematicas.multiplicar(calcN1,calcN2)

                txResultado.text = "El resultado es: " + resultadoOP.toString()
            }
            else if (spSeleccionarOperacion.selectedItem == "Dividir" ){

                var resultadoOP : Int = OpMatematicas.dividir(calcN1,calcN2)
                if ( resultadoOP == 0){
                    val toast = Toast.makeText(this,"No puedes dividir por 0",Toast.LENGTH_SHORT).show()
                    txResultado.text = "Syntax Error"
                } else {
                    txResultado.text = "El resultado es: " + resultadoOP.toString()
                }

            }


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}