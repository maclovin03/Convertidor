package com.example.cardview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener

class ConvertidorTemp : AppCompatActivity() {

    private lateinit var celsiusRd: RadioButton
    private lateinit var farenheitRd: RadioButton
    private lateinit var convertirBtn: Button
    private lateinit var temperatura: EditText
    private lateinit var resultado: TextView
    private lateinit var clearText: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_convertidor_temp)

        iniciarComponentes()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun iniciarComponentes() {
        celsiusRd = findViewById(R.id.celsiusRd)
        farenheitRd = findViewById(R.id.farenheitRd)
        convertirBtn = findViewById(R.id.convertirBtn)
        temperatura = findViewById(R.id.temperatura)
        resultado = findViewById(R.id.resultado)
        clearText = findViewById(R.id.clear_text)

        celsiusRd.setOnClickListener {
            temperatura.hint = "Farenheit"
        }
        farenheitRd.setOnClickListener {
            temperatura.hint = "Celsius"
        }
        clearText.setOnClickListener {
            temperatura.text.clear()
        }
        temperatura.addTextChangedListener {
            clearText.isVisible = it.toString().isNotEmpty()
        }
        convertirBtn.setOnClickListener {
            if (temperatura.text.toString().isEmpty()) {
                temperatura.error = "Ingrese una temperatura"

            } else {
                if (celsiusRd.isChecked) {
                    convertirFarenheitACelsius()
                } else if (farenheitRd.isChecked) {
                    convertirCelsiusAFarenheit()
                }
            }
        }
    }

    private fun convertirFarenheitACelsius() {

        val farenheit = temperatura.text.toString().toDouble()
        val celsius = (farenheit - 32) * 5 / 9
        resultado.text = "$farenheit F es igual a $celsius C"
    }

    private fun convertirCelsiusAFarenheit() {

        val celsius = temperatura.text.toString().toDouble()
        val farenheit = (celsius * 9 / 5) + 32
        resultado.text = "$celsius C es igual a $farenheit F"
    }
}
