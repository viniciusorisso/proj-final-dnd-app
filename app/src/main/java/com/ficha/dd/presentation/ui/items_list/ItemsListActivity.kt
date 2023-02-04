package com.ficha.dd.presentation.ui.items_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.MainActivity
import com.ficha.dd.databinding.ItemsListBinding
import com.ficha.dd.presentation.ItemsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemsListActivity : AppCompatActivity() {

    private lateinit var _binding: ItemsListBinding

    private val binding get() = _binding

    private val viewModel : ItemsViewModel by viewModel()

    private val adapter = ItemsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ItemsListBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)
        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        binding.itemsList.adapter = adapter
        binding.itemsList.layoutManager = LinearLayoutManager(this)
        binding.root.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupObservers() {
        viewModel.allItems.observe(this) { list->
            adapter.setItems(list)
        }
    }
}