package com.ficha.dd.presentation.ui.character_sheets_list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.MainActivity
import com.ficha.dd.databinding.CharacterSheetsListBinding
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.presentation.viewModel.CharactersSheetViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterSheetsActivity : AppCompatActivity() {

    private lateinit var _binding: CharacterSheetsListBinding

    private val binding get() = _binding

    private val viewModel : CharactersSheetViewModel by viewModel()

    private val adapter = CharacterSheetsAdapter() {
        goToCharacterSheetDetails(it)
    }

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

    private fun goToCharacterSheetDetails(character: CharacterSheet) {
        val intent = MainActivity.newIntent(character)
        try {

            startActivity(intent)
        }
        catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun setupObservers() {
        viewModel.allSheets.observe(this) { list->
            adapter.setItems(list)
        }
    }

}
