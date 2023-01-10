package com.example.pretesk_2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("posts/1")
    fun getUser(): Call<DTO>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<DTO>
}