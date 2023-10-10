package com.example.jueguitos
import android.os.Bundle
import kotlin.random.Random
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jueguitos.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    val symbols = arrayOf(R.drawable.sol, R.drawable.luna, R.drawable.dollar, R.drawable.jotchua)

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.volver.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
        }

        binding.girar.setOnClickListener{
            val longitud = symbols.size
            binding.reel1.setImageResource(symbols[Random.nextInt(longitud)])
            binding.reel2.setImageResource(symbols[Random.nextInt(longitud)])
            binding.reel3.setImageResource(symbols[Random.nextInt(longitud)])
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}