package com.ficha.dd.presentation.ui.item_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ficha.dd.MainActivity
import com.ficha.dd.databinding.ItemDetailsBinding
import com.ficha.dd.domain.model.CharacterSheet
import com.ficha.dd.domain.model.Item
import com.ficha.dd.presentation.viewModel.ItemDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailsActivity : AppCompatActivity(){
    private lateinit var _binding: ItemDetailsBinding

    private val binding get() = _binding

    private val viewModel: ItemDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ItemDetailsBinding.inflate(layoutInflater)

        val item = savedInstanceState?.getParcelable("item", Item::class.java)
        item?.let { viewModel.updateItem(it) }

        viewModel.updateItem(Item("name", "name","name"))

        val view = binding.root

        setupViews()
        setContentView(view)
    }

    private fun setupViews() {

        binding.detailsItemName.text = viewModel.itemDetails.value?.name
        binding.detailsItemCost.text = viewModel.itemDetails.value?.url
        binding.detailsItemDescription.text = viewModel.itemDetails.value?.index
//        binding.detailsItemName.text = viewModel.itemDetails.value?.name
    }

    companion object {
        fun newIntent(context: Context, item: Item): Intent {
            val intent: Intent = Intent(context, ItemDetailsActivity::class.java)
            val bundle = intent.extras
            bundle?.putParcelable("item", item)
            return intent
        }
    }
}
