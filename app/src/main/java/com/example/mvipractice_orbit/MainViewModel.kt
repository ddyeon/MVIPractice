package com.example.mvipractice_orbit

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel: ViewModel(), ContainerHost<CalculatorState, CalculatorSideEffect> {

    override val container: Container<CalculatorState, CalculatorSideEffect> = container(CalculatorState())

    fun add(number: Int) = intent {
        postSideEffect(CalculatorSideEffect.Toast("Adding $number to ${state.total}!"))
        reduce {
            state.copy(total = state.total + number)
        }
    }
}