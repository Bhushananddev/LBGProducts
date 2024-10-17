package com.lbg.products.products.domain.model


data class Product(

    val id: Int? = null,
    val title: String? = null,
    val price: Double? = null,
    val description: String? = null,
    val category: String? = null,
    val image: String? = null,
    val rating: Rating? = Rating()

)

