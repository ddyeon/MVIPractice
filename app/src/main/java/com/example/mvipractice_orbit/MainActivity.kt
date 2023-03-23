package com.example.mvipractice_orbit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvipractice_orbit.databinding.ActivityMainBinding
import org.orbitmvi.orbit.viewmodel.observe

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
        viewModel.observe(this,state = ::render, sideEffect = ::handleSideEffect)
    }

    private fun setOnClickListener() {
        binding.oneBtn.setOnClickListener { viewModel.add(2) }
        binding.twoBtn.setOnClickListener { viewModel.add(3) }
        binding.threeBtn.setOnClickListener { viewModel.add(5) }
        binding.resetBtn.setOnClickListener { viewModel.reset() }
    }

    private fun render(state: CalculatorState) {
        binding.result.text = state.total.toString()
    }

    private fun handleSideEffect(sideEffect: CalculatorSideEffect) {
        when (sideEffect) {
            is CalculatorSideEffect.Toast -> {
                Toast.makeText(this, sideEffect.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}