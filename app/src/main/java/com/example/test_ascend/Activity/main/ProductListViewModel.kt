package com.example.test_ascend.Activity.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_ascend.Activity.main.model.ProductModel
import com.example.test_ascend.Activity.main.repository.product.ProductRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class ProductListViewModel(private val productRepository: ProductRepository) : ViewModel() {

    var listProduct: MutableLiveData<List<ProductModel>> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun onGetProduct() {
        viewModelScope.launch {
            productRepository.getProductList().collect {
                if (it.isSuccess) {
                    it.data?.let { data ->
                        listProduct.value = data
                    }
                } else {
                    error.value = it.message
                }
            }
        }
    }
}