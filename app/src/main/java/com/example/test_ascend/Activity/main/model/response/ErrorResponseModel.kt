package com.example.test_ascend.Activity.main.model.response

import com.google.gson.annotations.SerializedName

data class ErrorResponseModel(
    @SerializedName("statusCode")
    var statusCode: String? = "",
    @SerializedName("message")
    var message: String = ""

)
