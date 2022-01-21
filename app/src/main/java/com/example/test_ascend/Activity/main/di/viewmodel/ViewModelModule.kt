package com.example.test_ascend.Activity.main.di.viewmodel

import com.example.test_ascend.Activity.main.detail_product.DetailProductViewModel
import com.example.test_ascend.Activity.main.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {
    val module = module {
        viewModel { (ProductListViewModel(productRepository = get())) }
        viewModel { (DetailProductViewModel(productByIdRepository = get())) }

    }
}