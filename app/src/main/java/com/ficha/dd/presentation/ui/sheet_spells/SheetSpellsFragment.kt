package com.ficha.dd.presentation.ui.sheet_spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.databinding.FragmentSpellsListBinding
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.presentation.ui.item_details.ItemDetailsActivity
import com.ficha.dd.presentation.ui.item_details.SpellDetailsActivity
import com.ficha.dd.presentation.viewModel.SheetSpellsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SheetSpellsFragment : Fragment() {

    private var _binding: FragmentSpellsListBinding? = null

    private val binding get() = _binding!!

    private val viewModel: SheetSpellsViewModel by viewModel()

    private val adapter = SheetSpellsAdapter() {
        goToSpellDetails(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpellsListBinding.inflate(inflater, container, false)
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
        binding.spellsSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filterSpellsList(p0)
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
        })

    }
    private fun setObservers() {
        viewModel.allSpells.observe(viewLifecycleOwner) {
            adapter.setSpells(it)
        }
    }

    private fun goToSpellDetails(spell: Spell) {
        val intent = SpellDetailsActivity.newIntent(requireContext(), spell)
        startActivity(intent)
    }
}