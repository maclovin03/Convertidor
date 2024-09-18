package com.example.cardview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ActivityImc : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var pesoEtxt: EditText
    private lateinit var alturaEtxt: EditText
    private lateinit var textResultado: TextView
    private val imc = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        iniciarBotones()
    }

    private fun iniciarBotones() {
        btnCalcular = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularIMC()
        }
        pesoEtxt = findViewById(R.id.peso)
        alturaEtxt = findViewById(R.id.altura)
        textResultado = findViewById(R.id.resultado)



    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC() {
        if (pesoEtxt.text.toString().isEmpty() || alturaEtxt.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show()

        }else {


            val imc = pesoEtxt.text.toString().toDouble() / (alturaEtxt.text.toString()
                .toDouble() * alturaEtxt.text.toString().toDouble())
            Toast.makeText(this, "IMC calculado", Toast.LENGTH_SHORT).show()
            textResultado.text = "Tu IMC es: ${imc.toFloat()}"
        }
    }
}