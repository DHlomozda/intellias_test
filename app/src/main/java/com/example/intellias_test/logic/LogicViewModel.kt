package com.example.intellias_test.logic


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intellias_test.converData.ConvertFromJsonItem
import com.example.intellias_test.network.EnglishApi
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response


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

    private fun getWordFromApi() {
    EnglishApi.retrofitService.getProperties(_word.value ?: "").enqueue(object : retrofit2.Callback<List<ConvertFromJsonItem>> {
            override fun onResponse(call: Call<List<ConvertFromJsonItem>>, response: Response<List<ConvertFromJsonItem>>) {
                setDescription(response)

        }

        override fun onFailure(call: Call<List<ConvertFromJsonItem>>, t: Throwable) {
            _description.value = "Failure " + t.message
        }
    })
    }


    private fun setDescription(response: Response<List<ConvertFromJsonItem>>) {
        val items = response.body()?.get(0)
        _description.value = "Your word: ${items?.word}\n"
        _description.value += "Phonetics: ${items?.phonetics?.get(0)?.text}\n"
        
    }

    //take word from view
    fun setWord(newWord: String) {
        _word.value = newWord
    }

    fun enterButtonClick() {
        getWordFromApi()
    }
}
