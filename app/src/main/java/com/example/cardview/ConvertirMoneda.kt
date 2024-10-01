package com.example.cardview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConvertirMoneda : AppCompatActivity() {

    private lateinit var etInput: EditText
    private lateinit var spinnerMoneda: Spinner
    private lateinit var btnCalcularConversion: Button
    private lateinit var btnLimpiarConv: Button
    private lateinit var btnCerrar: Button
    private lateinit var txtResultado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_convertir_moneda)


        etInput = findViewById(R.id.etInput)
        spinnerMoneda = findViewById(R.id.spinnerConv)
        btnCalcularConversion = findViewById(R.id.btnCalcularConversion)
        btnLimpiarConv = findViewById(R.id.btnLimpiarConv)
        btnCerrar = findViewById(R.id.btnCerrar)
        txtResultado = findViewById(R.id.resultadoConversion)

        val adapter  = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.array_conv))
        spinnerMoneda.adapter = adapter

        eventosClic()
        btnCalcularConversion.setOnClickListener {
            val dolara = resources.getString(R.string.dolara).toFloat()
            val dolarc = resources.getString(R.string.dolarc).toFloat()
            val euro = resources.getString(R.string.euro).toFloat()

            if(etInput.text.toString().isNotEmpty()){
                val cantidad = etInput.text.toString().toFloat()
                val resultado = when(spinnerMoneda.selectedItemPosition){
                    0 -> cantidad / dolara
                    1 -> cantidad / dolarc
                    2 -> cantidad / euro
                    3 -> cantidad * euro
                    4 -> cantidad * dolara
                    5 -> cantidad * dolarc
                    else -> 0.0f

                }
                txtResultado.text = resultado.toString()
            }else{
                Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show()
            }
        }

        btnLimpiarConv.setOnClickListener {
            etInput.text.clear()
            txtResultado.text = ""
        }

        btnCerrar.setOnClickListener {
           val builder = AlertDialog.Builder(this)
            builder.setTitle("Cerrar Aplicacion")
            builder.setMessage("¿Desea cerrar la aplicacion?")
            builder.setPositiveButton("Si"){_, _ ->
                finish()
            }

            builder.setNegativeButton("No"){_, _ ->
                Toast.makeText(this, "cancelar", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }

    }

    private fun eventosClic() {
        var pos = 0

        spinnerMoneda.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val item = p0?.getItemAtPosition(p2).toString()
                Toast.makeText(applicationContext, "el valor es $item"
                    + "posicion: $p2", Toast.LENGTH_SHORT).show()
                pos = p2
                txtResultado.text = ""
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}