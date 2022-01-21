package com.example.test_ascend.Activity.main.service

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpBuilder(val interceptor: TokenExpireInterceptor) {

    fun build(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .build()
    }
}