package com.example.test_ascend.Activity.main.repository.product

import com.example.test_ascend.Activity.main.datasource.IProductDataStore
import com.example.test_ascend.Activity.main.model.ProductModel
import kotlinx.coroutines.flow.map
import com.example.test_ascend.Activity.main.service.Result
import kotlinx.coroutines.flow.Flow

class ProductRepository(val dataStore: IProductDataStore) : IProductRepository {

    override suspend fun getProductList(): Flow<Result<List<ProductModel>>> {
        val response = dataStore.getProductList()
        return response.map {
            if (it.isSuccess) {
                val list = it.data?.map { data -> data.toModel() }
                return@map Result.success(list)
            } else {
                return@map Result.error(it.message)
            }
        }
    }

    override suspend fun getProductById(id: Int): Flow<Result<ProductModel>> {
        val response = dataStore.getProductById(id)
        return response.map {
            if (it.isSuccess) {
                return@map Result.success(it.data?.toModel())
            } else {
                return@map Result.error(it.message)
            }
        }
    }
}