package com.example.cardview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityHola : AppCompatActivity() {
    private lateinit var lblSaludo: TextView
    private lateinit var txtNombre: EditText
    private lateinit var btnSaludar: Button
    private lateinit var btnLimpiar:Button
    private lateinit var btnCerrar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hola)

        IniciarComponentes()
        eventosBotones()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }
    }
    fun IniciarComponentes(){
        lblSaludo = findViewById(R.id.lblSaludar) as TextView
        txtNombre = findViewById(R.id.txtNombre) as EditText
        btnSaludar = findViewById(R.id.btnSaludo)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)
    }

    fun eventosBotones(){
        btnSaludar.setOnClickListener {
            var strNombre = "";
            if (txtNombre.text.toString().contentEquals("")) {
                Toast.makeText(applicationContext, "Falto capturar el Nombre", Toast.LENGTH_SHORT)
                    .show()
            } else {
                strNombre = "Hola, " + txtNombre.text.toString() + " Como Estas ?"
                lblSaludo.text = strNombre
            }
        }
        btnLimpiar.setOnClickListener {
            txtNombre.setText("")
            lblSaludo.setText("")
        }
        btnCerrar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("App Hola")
            builder.setMessage("¿Deseas Salir de la Aplicacion?")
            builder.setPositiveButton("Aceptar") { dialog, which ->
                finish()
            }
            builder.setNegativeButton("Cancelar") { dialog, which ->
                Toast.makeText(applicationContext,
                    "Quizas",Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }

    }
}