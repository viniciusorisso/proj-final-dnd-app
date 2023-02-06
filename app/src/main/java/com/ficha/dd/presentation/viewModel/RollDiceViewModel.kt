package com.ficha.dd.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RollDiceViewModel: ViewModel() {
    private val _diceValue = MutableLiveData<Int>()
    val diceValue: LiveData<Int> = _diceValue

    init {
        _diceValue.value = 0
    }

    private fun setDiceValue(value: Int) {
        _diceValue.value = value
    }

    fun rollDice(dice: Int) {
        val randValue = (1..dice).random()

        setDiceValue(randValue)
    }
}