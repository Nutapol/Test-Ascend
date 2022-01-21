package com.example.test_ascend.Activity.main.service.api

import com.example.test_ascend.Activity.main.model.entity.ProductEntiry
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    fun getProductListAsync(): Deferred<Response<List<ProductEntiry>>>

    @GET("products/{id}")
    fun getProductByIdAsync(@Path("id") id: Int): Deferred<Response<ProductEntiry>>
}