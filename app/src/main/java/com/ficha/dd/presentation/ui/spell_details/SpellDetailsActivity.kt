package com.ficha.dd.presentation.ui.item_details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ficha.dd.databinding.SpellDetailsBinding
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.presentation.viewModel.ItemDetailsViewModel
import com.ficha.dd.presentation.viewModel.SpellDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellDetailsActivity : AppCompatActivity(){
    private lateinit var _binding: SpellDetailsBinding

    private val binding get() = _binding

    private val viewModel: SpellDetailsViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = SpellDetailsBinding.inflate(layoutInflater)

        val item = savedInstanceState?.getParcelable("spell", Spell::class.java)
        item?.let { viewModel.updateItem(it) }

        val view = binding.root

        setupViews()
        setContentView(view)
    }

    private fun setupViews() {

        binding.detailsSpellName.text = viewModel.spellDetails.value?.name
        binding.detailsSpellDescription.text = viewModel.spellDetails.value?.desc.toString()
        binding.detailsSpellAttackType.text = viewModel.spellDetails.value?.attack_type
        binding.detailsSpellLevel.text = viewModel.spellDetails.value?.level.toString()
        binding.detailsSpellRange.text = viewModel.spellDetails.value?.range
        binding.detailsSpellDuration.text = viewModel.spellDetails.value?.duration
    }

    companion object {
        fun newIntent(context: Context, spell: Spell): Intent {
            val intent: Intent = Intent(context, SpellDetailsActivity::class.java)
            val bundle = intent.extras
            bundle?.putParcelable("spell", spell)
            return intent
        }
    }
}
