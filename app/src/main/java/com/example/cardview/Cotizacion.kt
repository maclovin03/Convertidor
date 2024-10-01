package com.example.cardview

import kotlin.random.Random

class Cotizacion(
    private val plazos: Int,
    private val precio: Int,
    private val porPagInicial: Int){


    fun calcularPagoInicial() = (precio * porPagInicial / 100)

    fun calcularTotalFin() = precio - calcularPagoInicial()

    fun calcularPagoMensual() = calcularTotalFin() / plazos

    fun generarFolio() = Random.nextInt(100000, 999999)
}