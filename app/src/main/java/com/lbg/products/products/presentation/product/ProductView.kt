package com.lbg.products.products.presentation.product

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.lbg.products.products.domain.model.Product
import com.lbg.products.products.presentation.util.components.MyTopAppBar
import com.lbg.products.products.presentation.util.components.ProductCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.internal.notifyAll


@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
internal fun ProductScreen(productViewModel: ProductViewModel = hiltViewModel()) {
    /*var list: List<Product> = emptyList()

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = lifecycle) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {

        }
    }*/
    val state by productViewModel.productUIState.collectAsStateWithLifecycle()
    ProductContent(list = state)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductContent(list: List<Product>) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar()
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(count = 2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(list.size) {
                ProductCard(product = list[it])
            }
        }
    }
}