package com.example.e_commercetask.repo

import com.example.e_commercetask.network.ApiCalls
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val api: ApiCalls) {
    suspend fun getProducts() =
        api.getProducts()
}