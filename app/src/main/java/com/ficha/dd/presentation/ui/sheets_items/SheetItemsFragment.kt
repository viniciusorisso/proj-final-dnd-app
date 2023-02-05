package com.ficha.dd.presentation.ui.sheets_items

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.MainActivity
import com.ficha.dd.databinding.FragmentCharacterItemBinding
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.domain.model.Item
import com.ficha.dd.presentation.ui.item_details.ItemDetailsActivity
import com.ficha.dd.presentation.viewModel.SheetItemsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SheetItemsFragment : Fragment() {

    private var _binding: FragmentCharacterItemBinding? = null

    private val binding get() = _binding!!

    private val viewModel: SheetItemsViewModel by viewModel()

    private val adapter = SheetItemsAdapter(){
        goToItemDetails(it)
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        binding.characterSheetsItemsList.adapter = adapter
        binding.characterSheetsItemsList.layoutManager = LinearLayoutManager(context)
        binding.itemsSearchView.clearFocus()
        binding.itemsSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filterItemsList(p0)
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
        })

    }
    private fun setObservers() {
        viewModel.allItems.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }

    private fun goToItemDetails(item: Item) {
        val intent = ItemDetailsActivity.newIntent(requireContext(), item)
        startActivity(intent)
    }
}