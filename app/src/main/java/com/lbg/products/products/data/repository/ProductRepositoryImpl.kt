package com.lbg.products.products.data.repository

import com.lbg.products.products.data.API.ProductApi
import com.lbg.products.products.domain.model.Product
import com.lbg.products.products.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productApi: ProductApi) :
    ProductRepository {


    override suspend fun getProducts(): List<Product> {
        return productApi.getProducts()
    }

    override suspend fun getProduct(productId : Int): Product {
        return productApi.getProductDetails(productId)
    }


}

