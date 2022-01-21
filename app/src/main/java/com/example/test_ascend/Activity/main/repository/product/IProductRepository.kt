package com.example.test_ascend.Activity.main.repository.product

import com.example.test_ascend.Activity.main.model.ProductModel
import kotlinx.coroutines.flow.Flow
import com.example.test_ascend.Activity.main.service.Result

interface IProductRepository {
    suspend fun getProductList() : Flow<Result<List<ProductModel>>>
    suspend fun getProductById(password:Int ) : Flow<Result<ProductModel>>

}