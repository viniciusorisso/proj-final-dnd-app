package com.ficha.dd.presentation.ui.character_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ficha.dd.databinding.FragmentCharacterDetailsBinding
import com.ficha.dd.presentation.viewModel.CharacterDetailsViewModel
import com.ficha.dd.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.w3c.dom.Text

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null

    private val binding get() = _binding!!

    private val adapter = CharacterDetailsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val characterDetailsViewModel =
            ViewModelProvider(this).get(CharacterDetailsViewModel::class.java)

        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupViews()
        setObservers()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers() {
    }

    private fun setupViews() {
    }
}