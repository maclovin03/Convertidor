package com.example.cardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var cardHola: CardView
    private lateinit var cardConversion: CardView
    private lateinit var cardIMC: CardView
    private lateinit var cardCotizacion: CardView
    private lateinit var cardConvertirMoneda: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        cardIMC = findViewById(R.id.cvrIMC)
        cardCotizacion = findViewById(R.id.cvrCotizacion)
        cardIMC.setOnClickListener {
           val intent = Intent(this, ActivityImc::class.java)
            startActivity(intent)

        }

        cardConvertirMoneda = findViewById(R.id.cvrMoneda)
        cardConvertirMoneda.setOnClickListener {
            val intent = Intent(this, ConvertirMoneda::class.java)
            startActivity(intent)
        }

        cardCotizacion.setOnClickListener {
            val intent = Intent(this, ActivityCliente::class.java)
            startActivity(intent)
        }

        cardConversion = findViewById(R.id.cvrConversion)

        cardConversion.setOnClickListener {
            val intent = Intent(this, ConvertidorTemp::class.java)
            startActivity(intent)
        }

        cardHola = findViewById(R.id.cvrHola)
        cardHola.setOnClickListener {
            val intent = Intent(this, ActivityHola::class.java)
            startActivity(intent)
        }


    }
}