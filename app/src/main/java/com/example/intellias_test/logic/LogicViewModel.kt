package com.example.intellias_test.logic


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intellias_test.converData.ConvertFromJsonItem
import com.example.intellias_test.network.EnglishApi
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response


class LogicViewModel: ViewModel() {

    //word from user
    private val _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word

    //text which user get
    private val _description = MutableLiveData<String>()
    val description : LiveData<String>
        get() = _description

    init {
        _word.value = ""
        _description.value = ""
    }

    //get convert data from Json
    private fun getWordFromApi() {
    EnglishApi.retrofitService.getProperties(_word.value ?: "").enqueue(object : retrofit2.Callback<List<ConvertFromJsonItem>> {
            override fun onResponse(call: Call<List<ConvertFromJsonItem>>, response: Response<List<ConvertFromJsonItem>>) {
                if(response.body() == null) {
                    _description.value = "Can't find the word"
                }
                else {
                    setDescription(response)
                }

        }

        override fun onFailure(call: Call<List<ConvertFromJsonItem>>, t: Throwable) {
            _description.value = "Failure " + t.message + "\nProbably no connection to the internet"
        }
    })
    }


    //function to output text from API, looks life a piece of ..
    private fun setDescription(response: Response<List<ConvertFromJsonItem>>) {
        val items = response.body()?.get(0)
        _description.value = "Your word: \"${items?.word}\" \n"
        _description.value += "Phonetics: \"${items?.phonetics?.getOrNull(0)?.text ?: "doesn't have phonetic"}\" \n"
        _description.value += "Origin: \"${items?.origin }\" \n"
        _description.value += "Meaning: "
        items?.meanings?.forEach { meaning ->
            _description.value += "\n  Part of speech: \"${meaning.partOfSpeech}\" \n"
            meaning.definitions.forEach { def ->
                _description.value += "  Definition: \"${def.definition}\" \n"
                _description.value += "  Example: \"${def.example}\" \n"
                if(def.synonyms.isNotEmpty()) {
                    _description.value += "  Synonyms: \n"
                    def.synonyms.forEach { _description.value += "\"$it\", "  }
                    _description.value += "\n"
                }
                if(def.antonyms.isNotEmpty()) {
                    _description.value += "  Antonyms: \n"
                    def.synonyms.forEach { _description.value += "\"$it\", "  }
                    _description.value += "\n"
                }
            }
        }
    }

    //take word from view
    fun setWord(newWord: String) {
        _word.value = newWord
        //if user set empty field
        if(_word.value.toString().isEmpty()) {
            _description.value = "Field is empty. Please enter your word"
        }
        else {
            enterButtonClick()
        }

    }

    private fun enterButtonClick() {
        getWordFromApi()
    }
}


