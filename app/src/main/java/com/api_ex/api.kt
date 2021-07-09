package com.api_ex

import retrofit2.Call
import retrofit2.http.GET

interface api {
    @GET("/albums/1/photos")
    fun sendMessage(): Call<ApiModel>

    @GET("/albums/1/photos")
    fun getAllLanguages(): Call<List<ApiModel>>
}

