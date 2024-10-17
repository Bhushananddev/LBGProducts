package com.lbg.products.products.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lbg.products.products.domain.model.Product
import com.lbg.products.products.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private val _state = MutableStateFlow<List<Product>>(emptyList())
    val productUIState: StateFlow<List<Product>> = _state.asStateFlow()

    init {
        getProduct()
    }

    private fun getProduct() {

        viewModelScope.launch(Dispatchers.IO) {
            val list = productRepository.getProducts()
            _state.value = list
        }

        /*_state.update {
            when(it){
                is ProductUIState.Success ->  ProductUIState.Success(it.productList)
                is ProductUIState.Error ->  ProductUIState.Error(Throwable())
            }
        }*//* productRepository.getProducts().collect {
            _state.value = ProductUIState.Success(it)
             }*/
    }
}

sealed class ProductUIState {
    data class Success(val productList: List<Product>) : ProductUIState()
    data class Error(val error: Throwable) : ProductUIState()
}