package com.example.test_ascend.Activity.main.datasource

import com.example.test_ascend.Activity.main.base.BaseDataStore
import com.example.test_ascend.Activity.main.model.entity.ProductEntiry
import com.example.test_ascend.Activity.main.service.Result
import com.example.test_ascend.Activity.main.service.api.ProductService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductDataStore(val service: ProductService) : IProductDataStore, BaseDataStore() {
    override suspend fun getProductList(): Flow<Result<List<ProductEntiry>>> {
        val result = getResult(service.getProductListAsync())
        return flowOf(result)
    }

    override suspend fun getProductById(id: Int): Flow<Result<ProductEntiry>> {
        val result = getResult(service.getProductByIdAsync(id))
        return flowOf(result)
    }
}