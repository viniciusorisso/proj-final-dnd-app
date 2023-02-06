package com.ficha.dd.presentation.ui.character_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ficha.dd.databinding.FragmentRollDiceBinding
import com.ficha.dd.presentation.viewModel.RollDiceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RollDiceFragment : Fragment() {
    private var _binding: FragmentRollDiceBinding? = null

    private val binding get() = _binding!!

    private val rollDiceViewModel: RollDiceViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRollDiceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupViews()
        setupObservers()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupViews() {
        binding.rollDiceTitle.text = "Dados"
        binding.rollDiceValue.text = rollDiceViewModel.diceValue.value.toString()
    }

    private fun setupObservers() {
        binding.rollDiceD4.setOnClickListener {
            rollDiceViewModel.rollDice(4)
        }
        binding.rollDiceD6.setOnClickListener {
            rollDiceViewModel.rollDice(6)
        }
        binding.rollDiceD8.setOnClickListener {
            rollDiceViewModel.rollDice(8)
        }
        binding.rollDiceD10.setOnClickListener {
            rollDiceViewModel.rollDice(10)
        }
        binding.rollDiceD12.setOnClickListener {
            rollDiceViewModel.rollDice(12)
        }
        binding.rollDiceD20.setOnClickListener {
            rollDiceViewModel.rollDice(20)
        }
        rollDiceViewModel.diceValue.observe(viewLifecycleOwner) {
            binding.rollDiceValue.text = rollDiceViewModel.diceValue.value.toString()
        }
    }
}