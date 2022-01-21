package com.example.test_ascend.Activity.main.base

import com.example.test_ascend.Activity.main.model.response.ErrorResponseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Deferred
import retrofit2.Response
import com.example.test_ascend.Activity.main.service.Result

abstract class BaseDataStore {

    protected suspend fun <T> getResult(deferred: Deferred<Response<T>>): Result<T> {
        try {

            val response = deferred.await()

            if (response.code() == 200) {
                response.body()
                return Result.success(response.body())
            } else {

                val jsonString = response.errorBody()?.charStream()
                val data = Gson().fromJson(jsonString, ErrorResponseModel::class.java)
                return Result.error(data.message)
            }
        } catch (e: Exception) {
            return Result.error(e.message)
        }
    }
}