package com.ficha.dd.presentation.ui.item_details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ficha.dd.databinding.ItemDetailsBinding
import com.ficha.dd.presentation.viewModel.ItemDetailsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailsActivity : AppCompatActivity(){
    private var _binding: ItemDetailsBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ItemDetailsViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ItemDetailsBinding.inflate(layoutInflater)

        val item = intent.getStringExtra("item")
        lifecycleScope.launch {
            item?.let { viewModel.updateItem(it) }
        }

        val view = binding.root

        setupObservers()
        setContentView(view)
    }

    fun setupObservers() {
        viewModel.itemDetails.observe(this) {
            binding.detailsItemName.text = it?.name
            binding.detailsItemCost.text = "Price: ${it?.itemCost?.quantity.toString()} ${it?.itemCost?.unit.toString()}"
            binding.detailsItemDescription.text = "${if (it?.desc?.isEmpty() == true) "" else "Description:"} ${it?.desc.toString().replace("[", "").replace("]", "")}"
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newIntent(context: Context, item: String): Intent {
            val intent: Intent = Intent(context, ItemDetailsActivity::class.java)
            intent.putExtra("item",  item)
            return intent
        }
    }
}
