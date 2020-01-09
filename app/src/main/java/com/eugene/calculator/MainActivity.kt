package com.eugene.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButton()
    }

    fun setTextFields(str: String) {
        if (resultText.text != "") {
            mathOperation.text = resultText.text
            resultText.text = null
        }
        mathOperation.append(str)
    }

    fun initButton() {
        buttonZero.setOnClickListener { setTextFields("0") }
        buttonOne.setOnClickListener { setTextFields("1") }
        buttonTwo.setOnClickListener { setTextFields("2") }
        buttonThree.setOnClickListener { setTextFields("3") }
        buttonFour.setOnClickListener { setTextFields("4") }
        buttonFive.setOnClickListener { setTextFields("5") }
        buttonSix.setOnClickListener { setTextFields("6") }
        buttonSeven.setOnClickListener { setTextFields("7") }
        buttonEight.setOnClickListener { setTextFields("8") }
        buttonNine.setOnClickListener { setTextFields("9") }
        buttonMinus.setOnClickListener { setTextFields("-") }
        buttonPlus.setOnClickListener { setTextFields("+") }
        buttonMultiply.setOnClickListener { setTextFields("*") }
        buttonDel.setOnClickListener { setTextFields("/") }
        buttonDot.setOnClickListener { setTextFields(".") }
        buttonOpenBracket.setOnClickListener { setTextFields("(") }
        buttonCloseBracket.setOnClickListener { setTextFields(")") }
        buttonAC.setOnClickListener {
            mathOperation.text = null
            resultText.text = null
        }
        buttonBack.setOnClickListener {
            val result = mathOperation.text.toString()
            if (result.isNotEmpty()) {
                mathOperation.text = result.substring(0, result.length - 1)

                resultText.text = null
            }
        }
        buttonEqually.setOnClickListener {
            try {
                val equally = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = equally.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble()) {
                    resultText.text = longRes.toString()
                } else {
                    resultText.text = result.toString()
                }

            } catch (e: Exception) {
                Log.e("buttonEqually", e.message)
            }
        }
    }

}
