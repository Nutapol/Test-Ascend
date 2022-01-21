package com.example.test_ascend.Activity.main.service

data class Result<T>(val isSuccess: Boolean, val message: String?, val data: T?) {
    companion object {
        fun <T> success(data: T?): Result<T> = Result(true, null, data)
        fun <T> error(message: String?): Result<T> = Result(false, message, null)
    }
}