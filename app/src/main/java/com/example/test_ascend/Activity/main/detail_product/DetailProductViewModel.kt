package com.example.test_ascend.Activity.main.detail_product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_ascend.Activity.main.model.ProductModel
import com.example.test_ascend.Activity.main.repository.product.ProductRepository

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class DetailProductViewModel(private val productByIdRepository: ProductRepository):ViewModel() {

    var getProductById: MutableLiveData<ProductModel> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun onGetProductById(productId: Int) {
        viewModelScope.launch {
            productByIdRepository.getProductById(productId).collect {
                if (it.isSuccess) {
                    it.data?.let { data ->
                        getProductById.value = data
                    }
                } else {
                    error.value = it.message
                }
            }


        }
    }
}