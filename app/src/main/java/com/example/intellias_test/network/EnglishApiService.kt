package com.example.intellias_test.network

import androidx.fragment.app.viewModels
import com.example.intellias_test.logic.LogicViewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface EnglishApiService {

    @GET("en/{word}")
    fun getProperties(@Path("word") word: String) : Call<String>

}

object EnglishApi {
    val retrofitService : EnglishApiService by lazy {
        retrofit.create(EnglishApiService::class.java)
    }
}