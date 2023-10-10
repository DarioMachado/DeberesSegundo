package com.example.jueguitos

import android.os.Bundle
import kotlin.random.Random
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jueguitos.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var numero = Random.nextInt(0, 100)
        var intentos = 0
        repeat(100){
            println(Random.nextInt(0, 100))
        }
        binding.volver.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.adivinar.setOnClickListener {
            val inputText = binding.input.text.toString()
            val inputNumber: Int? = inputText.toIntOrNull()
            intentos++
            if (inputNumber != null) {
                if (inputNumber > numero) {
                    binding.pista.text = "El número que buscas es menor que $inputNumber"
                }
                else if (inputNumber < numero) {
                    binding.pista.text = "El número que buscas es mayor que $inputNumber"
                }
                else {
                    binding.pista.text = "¡Correcto! Has necesitado $intentos intentos para averiguarlo"
                }
            } else {

            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}