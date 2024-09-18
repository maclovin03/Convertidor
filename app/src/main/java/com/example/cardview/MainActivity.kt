package com.example.cardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var cardHola: CardView
    private lateinit var cardConversion: CardView
    private lateinit var cardIMC: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        cardIMC = findViewById(R.id.cvrIMC)
        cardIMC.setOnClickListener {
           val intent = Intent(this, ActivityImc::class.java)
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