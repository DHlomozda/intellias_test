package com.example.intellias_test.network


import com.example.intellias_test.converData.ConvertFromJsonItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/"
private val retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
}


interface EnglishApiService {

    @GET("en/{word}")
    fun getProperties(@Path("word") word: String) : Call<List<ConvertFromJsonItem>>

}

object EnglishApi {
    val retrofitService : EnglishApiService by lazy {
        retrofit.create(EnglishApiService::class.java)
    }
}