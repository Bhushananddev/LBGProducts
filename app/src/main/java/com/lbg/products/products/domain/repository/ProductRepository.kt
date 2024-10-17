package com.lbg.products.products.domain.repository

import com.lbg.products.products.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun getProduct(productId : Int): Product
}