package com.lbg.products.di

import com.lbg.products.products.data.repository.ProductRepositoryImpl
import com.lbg.products.products.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindRepository(productRepositoryImpl: ProductRepositoryImpl) : ProductRepository
}