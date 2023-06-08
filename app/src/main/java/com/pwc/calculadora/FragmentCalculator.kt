package com.pwc.calculadora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pwc.calculadora.databinding.FragmentCalculatorBinding

class FragmentCalculator: Fragment(){
    private lateinit var binding: FragmentCalculatorBinding
    private var currentNumber = ""
    private var currentOperator = ""
    private var result = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)

        // Set click listeners for number buttons
        binding.btn0.setOnClickListener { appendNumber("0") }
        binding.btn1.setOnClickListener { appendNumber("1") }
        binding.btn2.setOnClickListener { appendNumber("2") }
        binding.btn3.setOnClickListener { appendNumber("3") }
        binding.btn4.setOnClickListener { appendNumber("4") }
        binding.btn5.setOnClickListener { appendNumber("5") }
        binding.btn6.setOnClickListener { appendNumber("6") }
        binding.btn7.setOnClickListener { appendNumber("7") }
        binding.btn8.setOnClickListener { appendNumber("8") }
        binding.btn9.setOnClickListener { appendNumber("9") }

        // Set click listeners for operator buttons
        binding.btnPlus.setOnClickListener { setOperator("+") }
        binding.btnMinus.setOnClickListener { setOperator("-") }
        binding.btnMultiply.setOnClickListener { setOperator("*") }
        binding.btnDivide.setOnClickListener { setOperator("/") }

        // Set click listener for equal button
        binding.btnEqual.setOnClickListener { calculateResult() }

        // Set click listener for clear button
        binding.btnClear.setOnClickListener { clearCalculator() }

        return binding.root
    }

    private fun appendNumber(number: String) {
        currentNumber += number
        updateResultView()
    }

    private fun setOperator(operator: String) {
        currentOperator = operator
        result = currentNumber.toDouble()
        currentNumber = ""
    }

    private fun calculateResult() {
        val secondNumber = currentNumber.toDouble()
        when (currentOperator) {
            "+" -> result += secondNumber
            "-" -> result -= secondNumber
            "*" -> result *= secondNumber
            "/" -> result /= secondNumber
        }
        currentNumber = result.toString()
        updateResultView()
    }

    private fun clearCalculator() {
        currentNumber = ""
        currentOperator = ""
        result = 0.0
        updateResultView()
    }

    private fun updateResultView() {
        binding.calculatorResultTextView.text = currentNumber
    }

}