package com.ficha.dd.presentation.ui.character_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.databinding.FragmentCharacterItemBinding
import com.ficha.dd.presentation.viewModel.CharacterItemsViewModel
import com.ficha.dd.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterItemsFragment : Fragment() {

    private var _binding: FragmentCharacterItemBinding? = null

    private val binding get() = _binding!!

    private val viewModel by activityViewModel<MainViewModel>()

    private val characterItemViewModel: CharacterItemsViewModel by viewModel()

    private val adapter = CharacterItemsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterItemBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupViews()
        setObservers()
        return root
    }

    private fun setupViews() {
        binding.characterSheetsItemsList.adapter = adapter
        binding.characterSheetsItemsList.layoutManager = LinearLayoutManager(context)
    }
    private fun setObservers() {
        viewModel.character.observe(viewLifecycleOwner) {
            characterItemViewModel.updateItemList(it.itemsList)
        }
        characterItemViewModel.allItems.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }
}