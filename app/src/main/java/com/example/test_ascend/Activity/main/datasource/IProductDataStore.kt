package com.example.test_ascend.Activity.main.datasource

import com.example.test_ascend.Activity.main.model.entity.ProductEntiry
import kotlinx.coroutines.flow.Flow
import com.example.test_ascend.Activity.main.service.Result

interface IProductDataStore {
    suspend fun getProductList() : Flow<Result<List<ProductEntiry>>>
    suspend fun getProductById(id:Int) : Flow<Result<ProductEntiry>>
}