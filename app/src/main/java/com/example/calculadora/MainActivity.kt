package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var temp = 0
    var decoy = 0
    var strTemp = ""
    var currOp = ""
    var opCounter = 0
    val undf = "undefined"

    lateinit var txtRes:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCero = findViewById<Button>(R.id.btnCero)
        val btnUno = findViewById<Button>(R.id.btnUno)
        val btnDos = findViewById<Button>(R.id.btnDos)
        val btnTres = findViewById<Button>(R.id.btnTres)
        val btnCuatro = findViewById<Button>(R.id.btnCuatro)
        val btnCinco = findViewById<Button>(R.id.btnCinco)
        val btnSeis = findViewById<Button>(R.id.btnSeis)
        val btnSiete = findViewById<Button>(R.id.btnSiete)
        val btnOcho = findViewById<Button>(R.id.btnOcho)
        val btnNueve = findViewById<Button>(R.id.btnNueve)
        val btnIgual = findViewById<Button>(R.id.btnIgual)
        val btnMult = findViewById<Button>(R.id.btnMult)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)

        txtRes = findViewById<TextView>(R.id.txtRes)

        btnCero.setOnClickListener (this)
        btnUno.setOnClickListener (this)
        btnDos.setOnClickListener (this)
        btnTres.setOnClickListener (this)
        btnCuatro.setOnClickListener (this)
        btnCinco.setOnClickListener (this)
        btnSeis.setOnClickListener (this)
        btnSiete.setOnClickListener (this)
        btnOcho.setOnClickListener (this)
        btnNueve.setOnClickListener (this)
        btnMult.setOnClickListener (this)
        btnDiv.setOnClickListener (this)
        btnSuma.setOnClickListener (this)
        btnResta.setOnClickListener (this)
        btnIgual.setOnClickListener (this)

    }

    override fun onClick(p0: View?) {


        when(p0?.id){
            R.id.btnCero -> {
                if(txtRes.text.toString().length!=1 && temp!=0) {
                    if (txtRes.text.toString() != "0")
                        txtRes.text = "${txtRes.text}0"
                }

                if(temp!=0){
                    decoy = 0
                }
            }
            R.id.btnUno -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "1"
                else
                    txtRes.text = "${txtRes.text}1"

                if(temp!=0){
                    decoy = 1
                }
            }
            R.id.btnDos -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "2"
                else
                    txtRes.text = "${txtRes.text}2"

                if(temp!=0){
                    decoy = 2
                }
            }
            R.id.btnTres -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "3"
                else
                    txtRes.text = "${txtRes.text}3"

                if(temp!=0){
                    decoy = 3
                }

                Log.w("Info",txtRes.text.toString())
            }
            R.id.btnCuatro -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                txtRes.text = "4"
            else
                txtRes.text = "${txtRes.text}4"

                if(temp!=0){
                    decoy = 4
                }

            }
            R.id.btnCinco -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "5"
                else
                    txtRes.text = "${txtRes.text}5"

                if(temp!=0){
                    decoy = 5
                }
            }
            R.id.btnSeis -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "6"
                else
                    txtRes.text = "${txtRes.text}6"

                if(temp!=0){
                    decoy = 6
                }

            }
            R.id.btnSiete -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "7"
                else
                    txtRes.text = "${txtRes.text}7"

                if(temp!=0){
                    decoy = 7
                }

            }
            R.id.btnOcho -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "8"
                else
                    txtRes.text = "${txtRes.text}8"

                if(temp!=0){
                    decoy = 8
                }
            }
            R.id.btnNueve -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "9"
                else
                    txtRes.text = "${txtRes.text}9"

                if(temp!=0){
                    decoy = 9
                }

            }
            R.id.btnMult -> {

                currOp = "*"
                if(opCounter==0) {
                    temp = Integer.parseInt(txtRes.text.toString())
                    txtRes.text = "${txtRes.text} * "
                }

                opCounter++;
            }
            R.id.btnDiv -> {

                //temp = txtRes.text.toString().toInt()
                currOp = "/"
                if(opCounter==0) {
                    temp = Integer.parseInt(txtRes.text.toString())
                    txtRes.text = "${txtRes.text} / "
                }
                opCounter++;
            }
            R.id.btnSuma -> {
                currOp = "+"
                if(opCounter==0) {
                    temp = Integer.parseInt(txtRes.text.toString())
                    txtRes.text = "${txtRes.text} + "
                }
                opCounter++;
            }
            R.id.btnResta -> {
                currOp = "-"
                if(opCounter==0) {
                    temp = Integer.parseInt(txtRes.text.toString())
                    txtRes.text = "${txtRes.text} - "
                }
                opCounter++;
            }
            R.id.btnIgual -> {
                if(currOp == "*"){
                    temp *= decoy
                }
                else if (currOp == "/"){
                    if(decoy!=0){
                        temp /= decoy
                    }
                    else if(decoy == 0){
                        //txtRes.text = decoy.toString()
                        txtRes.invalidate()
                        txtRes.setText("undefined")

                        Log.w("Info","division by cero")
                        Log.w("Info",temp.toString())
                        Log.w("Info",decoy.toString())

                        //txtRes.invalidate()
                    }
                }
                else if (currOp == "+"){
                    temp += decoy
                }
                else if(currOp == "-"){
                    temp -= decoy
                }

                strTemp = temp.toString()
                //display
                txtRes.text = strTemp
                opCounter = 0;
            }

        }
    }
}