package com.ficha.dd.presentation.ui.item_details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ficha.dd.databinding.SpellDetailsBinding
import com.ficha.dd.domain.model.Spell
import com.ficha.dd.presentation.viewModel.SpellDetailsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellDetailsActivity : AppCompatActivity(){
    private var _binding: SpellDetailsBinding? = null

    private val binding get() = _binding!!

    private val viewModel: SpellDetailsViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = SpellDetailsBinding.inflate(layoutInflater)

        val spell = intent.getStringExtra("spell")
        lifecycleScope.launch {
            spell?.let { viewModel.updateSpell(it) }
        }

        val view = binding.root

        setupObservers()
        setContentView(view)
    }

    private fun setupObservers() {

        viewModel.spellDetails.observe(this) {
            binding.detailsSpellName.text = it?.name
            binding.detailsSpellDescription.text = "${if (it?.desc?.isEmpty() == true) "" else "Description:"} ${it?.desc.toString().replace("[", "").replace("]", "")}"
            binding.detailsSpellAttackType.text = it?.attack_type
            binding.detailsSpellLevel.text =
                "${if (it?.level.toString()?.isEmpty() == true) "" else "Range:"} ${it?.level.toString()}"
            binding.detailsSpellRange.text =
                "${if (it?.range?.isEmpty() == true) "" else "Range:"} ${it?.range}"
            binding.detailsSpellDuration.text =
                "${if (it?.duration?.isEmpty() == true) "" else "Duration:"} ${it?.duration}"
        }
    }

    companion object {
        fun newIntent(context: Context, spell: Spell): Intent {
            val intent: Intent = Intent(context, SpellDetailsActivity::class.java)
            intent.putExtra("spell",  spell.index)
            return intent
        }
    }
}
