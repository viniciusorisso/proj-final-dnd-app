package com.ficha.dd.presentation.ui.character_spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.databinding.FragmentCharacterSpellBinding
import com.ficha.dd.presentation.viewModel.CharacterSpellsViewModel
import com.ficha.dd.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterSpellsFragment : Fragment() {

    private var _binding: FragmentCharacterSpellBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel by activityViewModel<MainViewModel>()

    private val characterSpellViewModel: CharacterSpellsViewModel by viewModel()

    private val adapter = CharacterSpellsAdapter()

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
        viewModel.character.observe(viewLifecycleOwner) {
            characterSpellViewModel.updateSpellList(it.spellsList)
        }
        characterSpellViewModel.allSpells.observe(viewLifecycleOwner) {
            adapter.setSpells(it)
        }
    }
}