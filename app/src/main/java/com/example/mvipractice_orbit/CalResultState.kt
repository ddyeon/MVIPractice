package com.example.mvipractice_orbit

data class CalculatorState(
    var total : Int = 0
)

sealed class CalculatorSideEffect {
    data class Toast(val text: String) : CalculatorSideEffect()
}