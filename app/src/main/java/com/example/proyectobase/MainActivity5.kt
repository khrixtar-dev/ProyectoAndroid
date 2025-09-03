package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)


        //Numeros
        val btn1 : Button = findViewById(R.id.btn1)
        val btn2 : Button = findViewById(R.id.btn2)
        val btn3 : Button = findViewById(R.id.btn3)
        val btn4 : Button = findViewById(R.id.btn4)
        val btn5 : Button = findViewById(R.id.btn5)
        val btn6 : Button = findViewById(R.id.btn6)
        val btn7 : Button = findViewById(R.id.btn7)
        val btn8 : Button = findViewById(R.id.btn8)
        val btn9 : Button = findViewById(R.id.btn9)
        val btn0 : Button = findViewById(R.id.btn0)

        // Operadores
        val btnSumar : Button = findViewById(R.id.btnSumar)
        val btnRestar : Button = findViewById(R.id.btnRestar)
        val btnMultiplicar : Button = findViewById(R.id.btnMultiplicar)
        val btnDividir : Button = findViewById(R.id.btnDividir)

        // Extras
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)
        val btnParentesis : Button = findViewById(R.id.btnParentesis)
        val btnPorcentaje : Button = findViewById(R.id.btnPorcentaje)
        val btnPunto : Button = findViewById(R.id.btnPunto)

        //Resultado
        var txtResultado : TextView = findViewById(R.id.txtResultado)
        val btnIgual : Button = findViewById(R.id.btnIgual)
        var txtAntes : TextView = findViewById(R.id.txtAntes)
        var txtDespues : TextView = findViewById(R.id.txtDespues)

        var operacion: Boolean = false

        btn1.setOnClickListener {

            if (operacion == false){
                txtAntes.append("1")
            } else {
                txtDespues.append("1")
            }

        }
        btn2.setOnClickListener {
            if (operacion == false){
                txtAntes.append("2")
            } else {
                txtDespues.append("2")
            }
        }
        btn3.setOnClickListener {
            if (operacion == false){
                txtAntes.append("3")
            } else {
                txtDespues.append("3")
            }
        }
        btn4.setOnClickListener {
            if (operacion == false){
                txtAntes.append("4")
            } else {
                txtDespues.append("4")
            }
        }
        btn5.setOnClickListener {
            if (operacion == false){
                txtAntes.append("5")
            } else {
                txtDespues.append("5")
            }
        }
        btn6.setOnClickListener {
            if (operacion == false){
                txtAntes.append("7")
            } else {
                txtDespues.append("7")
            }
        }
        btn7.setOnClickListener {
            if (operacion == false){
                txtAntes.append("7")
            } else {
                txtDespues.append("7")
            }
        }
        btn8.setOnClickListener {
            if (operacion == false){
                txtAntes.append("8")
            } else {
                txtDespues.append("8")
            }
        }
        btn9.setOnClickListener {
            if (operacion == false){
                txtAntes.append("9")
            } else {
                txtDespues.append("9")
            }
        }
        btn0.setOnClickListener {
            if (operacion == false){
                txtAntes.append("0")
            } else {
                txtDespues.append("0")
            }
        }
        btnLimpiar.setOnClickListener {
            txtResultado.text=""
        }
        btnSumar.setOnClickListener {
            operacion = true
        }
        btnIgual.setOnClickListener {
            txtResultado.text = (txtAntes.text.toString().toInt() + txtDespues.text.toString().toInt()).toString()
            txtAntes.text = ""
            txtDespues.text = ""
            operacion = false
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}