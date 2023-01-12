package com.example.preteskproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET
    fun getPopularBooks(@Query("api_key") api_key : String) : Call<Books>
}