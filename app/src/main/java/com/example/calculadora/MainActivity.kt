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
import kotlin.math.pow
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var temp: Double = 0.0
    var decoy: Double = 0.0
    var strTemp = ""
    var currOp = ""
    var canDisplay = true
    var isUndefined = false
    var isDoneEntering = false
    var plurarlTriggered = false
    var opCounter = 0
    var activeDecimal = false
    var decimalCounter = 1
    var isOperator = false


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
        val btnDecimal = findViewById<Button>(R.id.btnDecimal)

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
        btnDecimal.setOnClickListener(this)

    }

    fun calculate (){
        if(currOp == "*"){
            temp = ((temp *  decoy) * 100.0).roundToInt()/100.0
            Log.w("Info",temp.toString())

        }
        else if (currOp == "/"){
            //temp /= decoy

            /*
            try {
                temp /= decoy
                Log.w("values","Trying division")

            }
            catch (e:ArithmeticException){
                Log.w("values","Division by zero")
                txtRes.text="undefined"
                isUndefined = true
                temp = 0.0
                decoy = 0.0

            }*/

            if(temp/decoy == Double.POSITIVE_INFINITY){
                Log.w("values","Division by zero")
                txtRes.text="undefined"
                isUndefined = true
                temp = 0.0
                decoy = 0.0
            }
            else{
                temp = ((temp /  decoy) * 100.0).roundToInt()/100.0
                Log.w("values","Trying division")
            }

        }
        else if (currOp == "+"){
            temp += decoy
        }
        else if(currOp == "-"){
            temp -= decoy
        }

    }

    fun writeScreen (num:String){

        if (!isUndefined){
            if(num.toInt()==0) {
                if((txtRes.text.toString() != "0")){
                    if(currOp != "" || !isDoneEntering)
                        txtRes.text = txtRes.text.toString() + num
                    else{
                        txtRes.text = num
                        temp = 0.0
                        decoy = 0.0
                        isDoneEntering = false
                        decimalCounter = 1
                        activeDecimal = false
                    }
                }

            }
            else{
                // change the value of the text at the very beginning
                if((txtRes.text.toString() == "0" || txtRes.text.toString() == "0.0"))
                    txtRes.text = num
                else
                //txtRes.text = "${txtRes.text}num"
                    if(currOp != "" || !isDoneEntering)
                        txtRes.text = txtRes.text.toString() + num
                    else{
                        txtRes.text = num
                        temp = 0.0
                        decoy = 0.0
                        isDoneEntering = false
                    }
            }
        }
        else{txtRes.text = num; isUndefined = false; decoy = 0.0;}

        if(isDoneEntering){
            //decoy = num.toInt()


            if(decoy!=0.0 && !activeDecimal)
                decoy = (decoy.toInt().toString()+num).toDouble()
            else if (!activeDecimal){
                decoy = num.toDouble()
            }
            else if(activeDecimal){
                decoy += num.toDouble()/((10.0).pow(decimalCounter))
                Log.w("values",decoy.toString())
                Log.w("values","decoy num to double: " + num.toDouble())
                Log.w("values","(decoy num.toDouble()/((10.0).pow():  " + (num.toDouble()/((10.0).pow(decimalCounter))))
                decimalCounter ++
            }
            Log.w("values",decoy.toString())


        }

        else if(!isDoneEntering){ //first time

            if(temp!=0.0 && !activeDecimal) {
                temp = (temp.toInt().toString() + num).toDouble()
                Log.w("values", "num: " + temp.toString()+num)
            }

            else if (!activeDecimal){
                temp = num.toDouble()
            }
            else if(activeDecimal){
                temp += (num.toDouble()/((10.0).pow(decimalCounter)))
                Log.w("values","num to double: " + num.toDouble())
                Log.w("values","(num.toDouble()/((10.0):  " + (num.toDouble()/((10.0))))


                decimalCounter ++
            }
            Log.w("values",temp.toString())


        }
    }
    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.btnDecimal ->{
                if(!activeDecimal){
                    activeDecimal = true
                    txtRes.text = "${txtRes.text} . "
                }

            }
            R.id.btnCero -> {

                writeScreen("0")

                if(!canDisplay && !isUndefined){
                    temp = 0.0
                    decoy = 0.0
                    txtRes.text = 0.toString()
                }
            }

            R.id.btnUno -> {
                writeScreen("1")
            }
            R.id.btnDos -> {
                writeScreen("2")
            }
            R.id.btnTres -> {
                writeScreen("3")
            }
            R.id.btnCuatro -> {
                writeScreen("4")
            }
            R.id.btnCinco -> {
                writeScreen("5")
            }
            R.id.btnSeis -> {
                writeScreen("6")
            }
            R.id.btnSiete -> {
                writeScreen("7")
            }
            R.id.btnOcho -> {
                writeScreen("8")
            }
            R.id.btnNueve -> {
                writeScreen("9")
            }
            R.id.btnMult -> {
                if(currOp == ""){
                    currOp = "*"
                    txtRes.text = "${txtRes.text} * "
                    isDoneEntering = true
                }

                if(decoy!=0.0){ plurarlTriggered = true }
                activeDecimal = false
                decimalCounter = 1

            }
            R.id.btnDiv -> {
                if(currOp == ""){
                    currOp = "/"
                    txtRes.text = "${txtRes.text} / "
                    isDoneEntering = true
                }

                if(decoy!=0.0){ plurarlTriggered = true }
                activeDecimal = false
                decimalCounter = 1
            }
            R.id.btnSuma -> {
                if(currOp == ""){
                    currOp = "+"
                    txtRes.text = "${txtRes.text} + "
                    isDoneEntering = true
                }

                if(decoy!=0.0){ plurarlTriggered = true }
                activeDecimal = false
                decimalCounter = 1
            }
            R.id.btnResta -> {
                if(currOp == ""){
                    currOp = "-"
                    txtRes.text = "${txtRes.text} - "
                    isDoneEntering = true
                }

                if(decoy!=0.0){ plurarlTriggered = true }
                activeDecimal = false
                decimalCounter = 1
            }

            R.id.btnIgual -> {

                if(decoy!=0.0){ plurarlTriggered = true }

                if(currOp != ""){
                    calculate()
                    currOp = ""
                }

                decimalCounter = 1

                if(isUndefined){
                    //txtRes.text="undefined"
                    temp = 0.0
                    isDoneEntering = false //restarts
                }
                else{
                    strTemp = temp.toString()
                    txtRes.text = strTemp
                }

                decoy = 0.0

            }
        }
    }
}