package com.example.e_commercetask.network
import com.example.e_commercetask.pojo.ModelProducts
import retrofit2.http.GET

interface ApiCalls {

    @GET("products")
    suspend fun getProducts(): ModelProducts
}