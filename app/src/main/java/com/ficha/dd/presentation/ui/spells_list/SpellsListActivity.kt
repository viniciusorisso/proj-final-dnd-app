package com.ficha.dd.presentation.ui.spells_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.MainActivity
import com.ficha.dd.databinding.SpellsListBinding
import com.ficha.dd.presentation.viewModel.SpellsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellsListActivity : AppCompatActivity() {

    private lateinit var _binding: SpellsListBinding

    private val binding get() = _binding

    private val viewModel: SpellsViewModel by viewModel()

    private val adapter = SpellsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = SpellsListBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)
        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        binding.spellsList.adapter = adapter
        binding.spellsList.layoutManager = LinearLayoutManager(this)
        binding.root.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupObservers() {
        viewModel.allSpells.observe(this) { list ->
            adapter.setSpells(list)
        }
    }
}