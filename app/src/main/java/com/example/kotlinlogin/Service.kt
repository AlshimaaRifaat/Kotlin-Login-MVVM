package com.example.kotlinlogin

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface Service {
    @FormUrlEncoded
    @POST("customer/login")
     fun userLogin(
        @Field("Email") email: String,
        @Field("Password") password: String
    ): Call<LoginModel>
}