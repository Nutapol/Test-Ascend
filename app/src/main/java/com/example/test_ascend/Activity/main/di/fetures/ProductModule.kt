package com.example.test_ascend.Activity.main.di.fetures

import com.example.test_ascend.Activity.main.datasource.ProductDataStore
import com.example.test_ascend.Activity.main.repository.product.ProductRepository
import com.example.test_ascend.Activity.main.service.RetrofitBuilder
import com.example.test_ascend.Activity.main.service.TokenExpireInterceptor
import com.example.test_ascend.Activity.main.service.api.ProductService
import com.example.test_ascend.BuildConfig
import org.koin.dsl.module

class ProductModule {

    val module = module {
        single<ProductService> { get<RetrofitBuilder>().build(BuildConfig.URL) }
        factory { ProductRepository(dataStore = get<ProductDataStore>()) }
        factory { ProductDataStore(service = get()) }
    }
}