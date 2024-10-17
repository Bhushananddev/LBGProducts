package com.lbg.products.products.data.API

import com.lbg.products.products.domain.model.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : List<Product>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id : Int) : Product
}