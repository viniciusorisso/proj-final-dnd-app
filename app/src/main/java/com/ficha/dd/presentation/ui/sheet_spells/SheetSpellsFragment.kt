package com.ficha.dd.presentation.ui.sheet_spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.databinding.FragmentCharacterSpellBinding
import com.ficha.dd.presentation.viewModel.SheetSpellsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SheetSpellsFragment : Fragment() {

    private var _binding: FragmentCharacterSpellBinding? = null

    private val binding get() = _binding!!

    private val characterSpellViewModel: SheetSpellsViewModel by viewModel()

    private val adapter = SheetSpellsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterSpellBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupViews()
        setObservers()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        binding.characterSheetsSpellsList.adapter = adapter
        binding.characterSheetsSpellsList.layoutManager = LinearLayoutManager(context)
    }
    private fun setObservers() {
        characterSpellViewModel.allSpells.observe(viewLifecycleOwner) {
            adapter.setSpells(it)
        }
    }
}