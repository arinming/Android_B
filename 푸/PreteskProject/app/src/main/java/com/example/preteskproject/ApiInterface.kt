package com.example.preteskproject

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET
    suspend fun getBookData() : Response<List<Item>>
}