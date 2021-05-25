package com.panda.calculadoraBasica

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private lateinit var num1View: EditText
    private lateinit var num2View: EditText
    private lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1View = findViewById(R.id.inputOne)
        num2View = findViewById(R.id.inputTwo)
        resultView = findViewById(R.id.resultView)

        val btnDelete: Button = findViewById(R.id.btnDelete)
        btnDelete.setOnClickListener {
            resultView.text = "O"
            num1View.text.clear()
            num2View.text.clear()
            num1 = 0.0
            num2 = 0.0
        }
        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {if ( validation()) resultView.text = (num1 + num2).toString()}

        val btnDif: Button = findViewById(R.id.btnDif)
        btnDif.setOnClickListener {if (validation()) resultView.text = (num1 - num2).toString()}

        val btnPro: Button = findViewById(R.id.btnPro)
        btnPro.setOnClickListener {if (validation()) resultView.text = (num1 * num2).toString()}

        val btnDiv: Button = findViewById(R.id.btnDiv)
        btnDiv.setOnClickListener {if (validation()) num1.toInt(); num2.toInt()
            resultView.text = (num1 / num2).toString()
        }
    }
        private fun validation():Boolean {

        if (!num1View.text.isNullOrEmpty() && !num2View.text.isNullOrEmpty()) {
            num2 = num2View.text.toString().toDouble()
            num1 = num1View.text.toString().toDouble()

        } else {
            Toast.makeText(this, "ingrese los Valores", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}