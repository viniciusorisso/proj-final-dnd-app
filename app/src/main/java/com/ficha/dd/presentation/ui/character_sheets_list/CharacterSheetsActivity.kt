package com.ficha.dd.presentation.ui.character_sheets_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.MainActivity
import com.ficha.dd.databinding.CharacterSheetsListBinding
import com.ficha.dd.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterSheetsActivity : AppCompatActivity() {

    private lateinit var _binding: CharacterSheetsListBinding

    private val binding get() = _binding

    private val viewModel : MainViewModel by viewModel()

    private val adapter = CharacterSheetsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = CharacterSheetsListBinding.inflate(layoutInflater)

        val view = binding.root

        setupViews()
        setupObservers()
        setContentView(view)
    }

    private fun setupViews() {
        binding.characterSheetsList.adapter = adapter
        binding.characterSheetsList.layoutManager = LinearLayoutManager(this)
        binding.root.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupObservers() {
        viewModel.allSheets.observe(this) { list->
            adapter.setItems(list)
        }
    }

}