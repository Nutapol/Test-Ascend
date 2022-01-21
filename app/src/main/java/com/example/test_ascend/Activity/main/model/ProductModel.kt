package com.example.test_ascend.Activity.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductModel(
    var id: Int? = 0,
    var title: String? = "",
    var image: String? = "",
    var content: String? = "",
    var isNewProduct: Boolean? = false,
    var price: Double? = 0.000
) : Parcelable

