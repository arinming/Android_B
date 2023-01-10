package com.example.pre_tesk2

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
    suspend fun getUserData() : Response<List<User>>
}