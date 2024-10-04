package com.example.sweatsmart3.network


import com.example.sweatsmart3.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    fun getUser(): Call<User>
}
