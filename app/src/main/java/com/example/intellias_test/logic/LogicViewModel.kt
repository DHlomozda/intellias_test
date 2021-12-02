package com.example.intellias_test.logic


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogicViewModel: ViewModel() {

    private val _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word

    private val _description = MutableLiveData<String>()
    val description : LiveData<String>
        get() = _description

    init {
        _word.value = ""
        _description.value = ""
    }


    //take word from view
    fun setWord(newWord: String) {
        _word.value = newWord
    }

    fun enterButtonClick() {

        _description.value = _word.value
    }
}