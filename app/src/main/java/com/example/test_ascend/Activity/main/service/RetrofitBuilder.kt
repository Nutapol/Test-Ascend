package com.example.test_ascend.Activity.main.service

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(val okHttpClient: OkHttpClient) {

    companion object {
        val retrofit: Retrofit.Builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
    }

    inline fun <reified T> build(baseUrl: String): T {
        return retrofit
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()
            .create(T::class.java)
    }
}