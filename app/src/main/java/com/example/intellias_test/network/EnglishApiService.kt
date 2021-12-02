package com.example.intellias_test.network

import androidx.fragment.app.viewModels
import com.example.intellias_test.logic.LogicViewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.dictionaryapi.dev/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface EnglishApiService {
    @GET("api/v2/entries/en/hello")
    fun getProperties() : Call<String>

}

object EnglishApi {
    val retrofitService : EnglishApiService by lazy {
        retrofit.create(EnglishApiService::class.java)
    }
}