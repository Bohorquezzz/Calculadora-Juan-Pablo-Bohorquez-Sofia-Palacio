package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import java.time.temporal.Temporal

class MainActivity : AppCompatActivity() {

    val SUMA="+"
    val RESTA="-"
    val MULTIPLICACION="*"
    val DIVISION="/"
    val PORCENTAJE="%"

    var operacionActual=""
    var primerNumero:Double= Double.NaN
    var segundoNumero:Double= Double.NaN

    lateinit var tvTemporal:TextView
    lateinit var tvResult: TextView

    lateinit var formatoDecimal:DecimalFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formatoDecimal= DecimalFormat("#.#########")
        tvTemporal=findViewById(R.id.tvTemporal)
        tvTemporal=findViewById(R.id.tvResultado)
    }
    fun cambiarOperador(b:View){
        val boton:Button = b as Button
        if(boton.text.toString().trim()=="÷"){
            operacionActual="/"}
        else if(boton.text.toString().trim()=="x"){
            operacionActual="*"}
        else{
            operacionActual=boton.text.toString().trim()}


    }
    fun calcular(b:View){
        if(Double.NaN!=primerNumero){
            segundoNumero = tvTemporal.text.toString().toDouble()
            tvTemporal.text=""

            when(operacionActual){
                "+"-> primerNumero = (primerNumero+segundoNumero)
                "-"-> primerNumero = (primerNumero-segundoNumero)
                "*"-> primerNumero = (primerNumero*segundoNumero)
                "/"-> primerNumero = (primerNumero/segundoNumero)
                "%"-> primerNumero = (primerNumero%segundoNumero)

            }
        }else{

            primerNumero = tvTemporal.text.toString().toDouble()
        }
    }

    fun seleccionarNumero(b:View) {
        val boton: Button = b as Button
        if (tvTemporal.text.toString() == "0"){
            tvTemporal.text = ""
        }
        tvTemporal.text = tvTemporal.text.toString()+boton.text.toString()
    }
}
