package com.example.intellias_test.logic


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intellias_test.network.EnglishApi
import com.example.intellias_test.network.EnglishApiService
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import javax.security.auth.callback.Callback



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
    EnglishApi.retrofitService.getProperties(_word.value ?: "hello").enqueue(object : retrofit2.Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
            _description.value = response.body()

        }

        override fun onFailure(call: Call<String>, t: Throwable) {
            _description.value = "Failure " + t.message
        }
    })
    }

    //take word from view
    fun setWord(newWord: String) {
        _word.value = newWord
    }

    fun enterButtonClick() {
        getWordFromApi()
    }
}
