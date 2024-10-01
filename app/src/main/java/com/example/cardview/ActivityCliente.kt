package com.example.cardview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityCliente : AppCompatActivity() {

    private lateinit var txtCliente: EditText
    private lateinit var btnEntrar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cliente)
        initUi()
        eventosClick()
    }

    private fun eventosClick() {
        btnEntrar.setOnClickListener {
            if (txtCliente.text.toString().isNotEmpty()) {
                val intent = android.content.Intent(this, CotizacionCarroActivity::class.java)
                intent.putExtra("cliente", txtCliente.text.toString())
                startActivity(intent)
            }else{
                txtCliente.error = "Campo requerido"
                txtCliente.requestFocus()
            }
        }
        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun initUi() {
        btnEntrar = findViewById(R.id.btnEntrar)
        btnRegresar = findViewById(R.id.btnRegresar)
        txtCliente = findViewById(R.id.txtCliente)
    }
}