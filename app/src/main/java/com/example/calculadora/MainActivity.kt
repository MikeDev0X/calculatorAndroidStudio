package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var temp = 0
    var decoy = 0
    var strTemp = ""
    var currOp = ""

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

    fun calculate (){
        if(currOp == "*"){
            temp *= decoy
            Log.w("Info",temp.toString())

        }
        else if (currOp == "/"){
            //temp /= decoy

            try {
                temp /= decoy
            }
            catch (e:ArithmeticException){
                Log.w("Info","Division by zero")
                txtRes.setText("undefined")
                temp = 0
                decoy = 0

            }
            
        }
        else if (currOp == "+"){
            temp += decoy
        }
        else if(currOp == "-"){
            temp -= decoy
        }

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
                else{
                    temp = 0
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
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
                else{
                    temp = 1
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
                }

                Log.w("Info",temp.toString())

            }
            R.id.btnDos -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                    txtRes.text = "2"
                else
                    txtRes.text = "${txtRes.text}2"

                if(temp!=0){
                    decoy = 2
                }
                else{
                    temp = 2
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
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
                else{
                    temp = 3
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
                }
            }
            R.id.btnCuatro -> {
                if(txtRes.text.toString() == "0" && txtRes.text.toString().length == 1)
                txtRes.text = "4"
            else
                txtRes.text = "${txtRes.text}4"

                if(temp!=0){
                    decoy = 4
                }
                else{
                    temp = 4
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
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
                else{
                    temp = 5
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
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
                else{
                    temp = 6
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
                    //Log.w("Info",temp.toString())
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
                else{
                    temp = 7
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
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
                else{
                    temp = 8
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
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
                else{
                    temp = 9
                }

                if(currOp != ""){
                    calculate()
                    currOp = ""
                }

            }
            R.id.btnMult -> {
                currOp = "*"
                txtRes.text = "${txtRes.text} * "
            }
            R.id.btnDiv -> {
                currOp = "/"
                txtRes.text = "${txtRes.text} / "
            }
            R.id.btnSuma -> {
                currOp = "+"
                txtRes.text = "${txtRes.text} + "
            }
            R.id.btnResta -> {
                currOp = "-"
                txtRes.text = "${txtRes.text} - "
            }

            R.id.btnIgual -> {

                strTemp = temp.toString()
                //display
                txtRes.text = strTemp
            }

        }
    }
}