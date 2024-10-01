package com.example.cardview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable
import kotlin.random.Random

class CotizacionCarroActivity : AppCompatActivity() {

    private lateinit var numReciboEt: EditText
    private lateinit var nombreEt: EditText
    private lateinit var diasTrabajadosEt: EditText
    private lateinit var txtNombre: TextView

    private lateinit var rb12: RadioButton
    private lateinit var rb24: RadioButton
    private lateinit var rb36: RadioButton
    private lateinit var rb48: RadioButton

    private lateinit var subtotalEt: EditText
    private lateinit var impuestoEt: EditText
    private lateinit var totalEt: EditText
    private lateinit var folio: TextView

    private lateinit var calcularBtn: Button
    private lateinit var limpiarBtn: Button
    private lateinit var salirBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cotizacion_carro)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        numReciboEt = findViewById(R.id.noReciboET)
        nombreEt = findViewById(R.id.nombreET)
        diasTrabajadosEt = findViewById(R.id.diasET)

        rb12 = findViewById(R.id.auxiliarRb)
        rb24 = findViewById(R.id.albanilRb)
        rb36 = findViewById(R.id.ingRb)
        rb48 = findViewById(R.id.rb48)

        folio = findViewById(R.id.txtFolio)

        subtotalEt = findViewById(R.id.subtotalET)
        impuestoEt = findViewById(R.id.impuestoET)
        totalEt = findViewById(R.id.totalET)

        txtNombre = findViewById(R.id.textView4)

        calcularBtn = findViewById(R.id.calcularBtn)
        limpiarBtn = findViewById(R.id.limpiarBtn)
        salirBtn = findViewById(R.id.terminarBtn)

        val cliente = intent.getStringExtra("cliente")
        txtNombre.text = cliente

        folio.text = "Folio: " + Random.nextInt(100000, 999999).toString()


        calcularBtn.setOnClickListener {
            if (numReciboEt.text.toString().isEmpty() || nombreEt.text.toString().isEmpty()
                || diasTrabajadosEt.text.toString()
                    .isEmpty() || !rb12.isChecked && !rb24.isChecked && !rb36.isChecked && !rb48.isChecked
            ) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else{
                calcular()
            }
        }
        limpiarBtn.setOnClickListener { limpiar() }
        salirBtn.setOnClickListener {
            val dialogo = AlertDialog.Builder(this)
            dialogo.setTitle("Salir")
            dialogo.setMessage("¿Desea salir de Cotizacion?")
            dialogo.setPositiveButton("Sí") { _, _ ->
                finish()
            }
            dialogo.setNegativeButton("No", null)
            dialogo.show()
        }


    }

    private fun limpiar() {

        numReciboEt.setText("")
        nombreEt.setText("")
        diasTrabajadosEt.setText("")
        rb12.isChecked = true
        subtotalEt.setText("")
        impuestoEt.setText("")
        totalEt.setText("")
        folio.text = ""
    }

    private fun calcular() {

        if (rb12.isChecked){
            initCotizacion(12)
        }else if (rb24.isChecked){
            initCotizacion(24)
        }else if (rb36.isChecked){
            initCotizacion(36)
        }else if (rb48.isChecked){
            initCotizacion(48)
        }

    }

    private fun initCotizacion(plazo: Int){
        val cotizacion = Cotizacion(
            plazo,
            diasTrabajadosEt.text.toString().toInt(),
            nombreEt.text.toString().toInt())

        subtotalEt.setText(cotizacion.calcularPagoInicial().toString())
        impuestoEt.setText(cotizacion.calcularTotalFin().toString())
        totalEt.setText(cotizacion.calcularPagoMensual().toString())
        folio.text = "Folio: " + cotizacion.generarFolio().toString()

    }


}