package com.example.omninews.Retrofit

import com.example.omninews.model.DataFromOmni
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiInterface
{
    @GET()
    fun getDataFromOmninews(@Url searchResult: String): Call<DataFromOmni>
}