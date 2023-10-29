package com.example.p_13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var exchangeRateEditText: EditText
    private lateinit var amountEditText: EditText
    private lateinit var convertButton: Button
    private lateinit var resultEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exchangeRateEditText = findViewById(R.id.editText)
        amountEditText = findViewById(R.id.editText2)
        convertButton = findViewById(R.id.button)
        resultEditText = findViewById(R.id.editText3)

        convertButton.setOnClickListener { convertCurrency() }

    }
    private fun convertCurrency() {
        val exchangeRateStr = exchangeRateEditText.text.toString()
        val amountStr = amountEditText.text.toString()
        if (exchangeRateStr.isBlank()) {
            Toast.makeText(this, "Введите курс обмена!", Toast.LENGTH_SHORT).show()
            return
        }

        if (amountStr.isBlank()) {
            Toast.makeText(this, "Введите сумму для обмена!", Toast.LENGTH_SHORT).show()
            return
        }

        val exchangeRate = exchangeRateStr.toDoubleOrNull()
        val amount = amountStr.toDoubleOrNull()

        if (exchangeRate == null || exchangeRate <= 0) {
            Toast.makeText(this, "Некорректное значение курса обмена!", Toast.LENGTH_SHORT).show()
            return
        }

        if (amount == null || amount <= 0) {
            Toast.makeText(this, "Некорректное значение суммы обмена!", Toast.LENGTH_SHORT).show()
            return
        }

        val result = amount * exchangeRate
        resultEditText.setText(result.toString())
    }
    }

